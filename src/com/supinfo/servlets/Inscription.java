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

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.supinfo.dao.jpa.JpaUtilisateurDao;
import com.supinfo.entity.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = null;
		String prenom = null;
		String password = null;
		String verif_pass = null;
		String mail = null;
		int id = 2;
		
		HttpSession session = request.getSession();
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		password = request.getParameter("password");
		verif_pass = request.getParameter("verif_pass");
		mail = request.getParameter("mail");
		
		// Verification
		if(userExist(mail)){			
			// Verification des mots de passe
			if(password.equals(verif_pass)){
				
				try {
					MessageDigest digest = MessageDigest.getInstance("MD5");
					digest.update(password.getBytes(), 0, password.length());
					password = new BigInteger(1, digest.digest()).toString(16);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Ajout en BDD
				Utilisateur utilisateur = new Utilisateur();
				
				JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
				
				utilisateur.setMail_utilisateur(mail);
				utilisateur.setMdp_utilisateur(password);
				utilisateur.setNom_utilisateur(nom);
				utilisateur.setPrenom_utilisateur(prenom);
				
				utilisateurDao.createUtilisateur(utilisateur);
				
				session.setAttribute("id", id);
				session.setAttribute("prenom", prenom);
				response.sendRedirect("/SupCrowdfunder/accueil");
			} else {
				String erreurMdp = "Les mots de passe ne sont pas identique !";
				request.setAttribute("erreurMdp", erreurMdp);
				this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
			}
		} else {
			String erreurLogin = "Login non disponible !";
			request.setAttribute("erreurLogin", erreurLogin);
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
		
		
		
	}
	
	public Boolean userExist(String mail)
	{
		//verification dans le fichier de DAO
		return true;
	}

}
