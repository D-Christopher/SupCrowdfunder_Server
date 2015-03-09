package com.supinfo.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.dao.jpa.JpaCategorieDao;
import com.supinfo.dao.jpa.JpaProjetDao;
import com.supinfo.dao.jpa.JpaUtilisateurDao;
import com.supinfo.entity.Categorie;
import com.supinfo.entity.Projet;

/**
 * Servlet implementation class ajouterProjet
 */
@WebServlet("/auth/ajouterProjet")
public class AjouterProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
		List<Categorie> categorieList = categorieDao.getAllCategorie();
		request.setAttribute("categorie", categorieList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/auth/ajouterProjet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Initialisation des variables
		String titre = null;
		String descriptProjet = null;
		String descriptRecompense = null;
		int objectif = 0;
		Date dateActuelle = new Date();
		String date_limite = request.getParameter("date_limite");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateLimite= new Date();
	
			 try {
				dateLimite = formatter.parse(date_limite);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		HttpSession session = request.getSession();
		
		// Recuperation des champs du formulaire
		titre = request.getParameter("titre");
		descriptProjet = request.getParameter("descriptProjet");
		descriptRecompense = request.getParameter("descriptRecompense");
		objectif = Integer.parseInt(request.getParameter("objectif"));
		int id_categorie = Integer.parseInt(request.getParameter("categorie"));
		int id = (int) session.getAttribute("id_utilisateur");
		System.out.println(id);
		
		// Creation du projet
		Projet projet = new Projet();
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
		
		projet.setTitre_projet(titre);
		projet.setDescription_projet(descriptProjet);
		projet.setRecompense_projet(descriptRecompense);
		projet.setArgent_objectif_projet(objectif);
		projet.setArgent_actuel_projet(0);
		projet.setDate_creation_projet(dateActuelle);
		projet.setDate_limite_projet(dateLimite);
		projet.setCategorie(categorieDao.getCategorieById(id_categorie));
		projet.setUtilisateur(utilisateurDao.getUtilisateurById(id));
    	projetDao.createProjet(projet);
    	
    	response.sendRedirect("/SupCrowdfunder/accueil");
	}

}
