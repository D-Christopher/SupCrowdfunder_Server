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

import antlr.PythonCodeGenerator;

import com.supinfo.dao.jpa.JpaUtilisateurDao;
import com.supinfo.entity.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mail = null;
		Utilisateur utilisateur = new Utilisateur();
		
		HttpSession session = request.getSession();
		mail = request.getParameter("mail");
		
		JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
		utilisateur = utilisateurDao.getUtilisateurByMail(mail);		
		
		if(utilisateur == null){
			// Si l'utilisateur n'existe pas
			String messageErreur = "Le login ou le mot de passe n'est pas valide !";
			request.setAttribute("messageErreur", messageErreur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		} else {
			String passBdd = request.getParameter("password");
			
			try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				digest.update(passBdd.getBytes(), 0, passBdd.length());
				passBdd = new BigInteger(1, digest.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(utilisateur.getMdp_utilisateur().equals(passBdd)){
				session.setAttribute("id_utilisateur", utilisateur.getId_utilisateur());
				session.setAttribute("prenom_utilisateur", utilisateur.getPrenom_utilisateur());
				session.setAttribute("nom_utilisateur", utilisateur.getNom_utilisateur());
				session.setAttribute("mail_utilisateur", utilisateur.getMail_utilisateur());
				session.setAttribute("admin", utilisateur.isAdmin_utilisateur());
				response.sendRedirect("/SupCrowdfunder/accueil");
			} else {
				String messageErreur = "Le login ou le mot de passe n'est pas valide !";
				request.setAttribute("messageErreur", messageErreur);
				this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
			}
			
		}
	}

}
