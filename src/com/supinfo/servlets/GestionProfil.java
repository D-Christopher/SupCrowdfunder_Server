package com.supinfo.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.dao.jpa.JpaUtilisateurDao;
import com.supinfo.entity.Utilisateur;

/**
 * Servlet implementation class GestionProfil
 */
@WebServlet("/auth/gestionProfil")
public class GestionProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
		int id = (Integer) session.getAttribute("id_utilisateur");
		Utilisateur utilisateur = utilisateurDao.getUtilisateurById(id);
		String mail = utilisateur.getMail_utilisateur();
		request.setAttribute("mail", mail);
		this.getServletContext().getRequestDispatcher("/WEB-INF/auth/gestionProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
		int id = (Integer) session.getAttribute("id_utilisateur");
		Utilisateur utilisateur = utilisateurDao.getUtilisateurById(id);
		String mail = utilisateur.getMail_utilisateur();
		request.setAttribute("mail", mail);
		String messageErreur;
		String Pass = request.getParameter("password");
		
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(Pass.getBytes(), 0, Pass.length());
			Pass = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(utilisateur.getMdp_utilisateur().equalsIgnoreCase(Pass))
		{
		utilisateur.setMail_utilisateur(request.getParameter("changer_mail"));
		if(!request.getParameter("new_password").isEmpty() &&!request.getParameter("verif_pass").isEmpty() )
		{
			String nouveaupass = request.getParameter("new_password");
			String verifpass = request.getParameter("verif_pass");
			
			try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				digest.update(nouveaupass.getBytes(), 0, nouveaupass.length());
				nouveaupass = new BigInteger(1, digest.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(nouveaupass.equalsIgnoreCase(verifpass))
			{
				utilisateur.setMdp_utilisateur(nouveaupass);
			}
			else
			{
				messageErreur  ="Vos nouveaux mots de passe ne correspondent pas";
				request.setAttribute("messageErreur", messageErreur);
				
			}
		}
		
			messageErreur  ="Modification effectué";
			request.setAttribute("messageErreur", messageErreur);
			utilisateurDao.updateUtilisateur(utilisateur);
			//response.sendRedirect("/SupCrowdfunder");
		
		}
		else
		{
			messageErreur = "Votre mot de passe actuel n'est pas valide";
			request.setAttribute("messageErreur", messageErreur);
			
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/auth/gestionProfil.jsp").forward(request, response);
	}

}
