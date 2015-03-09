package com.supinfo.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class EditionProjet
 */
@WebServlet("/admin/editionprojet")
public class EditionProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditionProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		
		if(request.getParameter("id")!= null)
		{
			HttpSession session = request.getSession();
			JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
			List<Categorie> categorieList  = categorieDao.getAllCategorie();
			request.setAttribute("categorie", categorieList);
			int id = Integer.parseInt(request.getParameter("id"));
			Projet projet = new Projet();
			projet = projetDao.getProjetById(id);
			session.setAttribute("projet", projet);
			String titre = projet.getTitre_projet();
			String description = projet.getDescription_projet();
			String recompense = projet.getRecompense_projet();
			String argent_objectif = Integer.toString(projet.getArgent_objectif_projet());
			Categorie categorie = projet.getCategorie();
			String categorie_projet = categorie.getNom_categorie();
			request.setAttribute("titre", titre);
			request.setAttribute("description", description);
			request.setAttribute("recompense", recompense);
			request.setAttribute("argent", argent_objectif);
			request.setAttribute("categorieProjet", categorie_projet);
			System.out.println("Description : "+description);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/editionProjet.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/editionProjet.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Recuperation des champs du formulaire
		String titre = request.getParameter("titre");
		String descriptProjet = request.getParameter("descriptProjet");
		String descriptRecompense = request.getParameter("descriptRecompense");
		int objectif = Integer.parseInt(request.getParameter("objectif"));
		int id_categorie = Integer.parseInt(request.getParameter("categorie"));
		
		// Update du projet

		Projet projet = new Projet();
		projet = (Projet) session.getAttribute("projet");
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
		
		projet.setTitre_projet(titre);
		projet.setDescription_projet(descriptProjet);
		projet.setRecompense_projet(descriptRecompense);
		projet.setArgent_objectif_projet(objectif);
		projet.setCategorie(categorieDao.getCategorieById(id_categorie));
		projetDao.updateProjet(projet);

		response.sendRedirect("/SupCrowdfunder/admin");
		
	}

}
