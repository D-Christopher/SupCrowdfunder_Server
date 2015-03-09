package com.supinfo.servlets;

import java.io.IOException;
import java.util.Date;
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
import com.supinfo.entity.Categorie;
import com.supinfo.entity.Projet;

/**
 * Servlet implementation class DetailProjet
 */
@WebServlet("/detailprojet")
public class DetailProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailprojet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			String argent_actuel = Integer.toString(projet.getArgent_actuel_projet());
			String argent_objectif = Integer.toString(projet.getArgent_objectif_projet());
			String dateLimite = projet.getDate_limite_projet().toString();
			String dateCrea = projet.getDate_creation_projet().toString();
			Categorie categorie = projet.getCategorie();
			String categorie_projet = categorie.getNom_categorie();
			
			request.setAttribute("titre", titre);
			request.setAttribute("description", description);
			request.setAttribute("recompense", recompense);
			request.setAttribute("argentObj", argent_objectif);
			request.setAttribute("argentActu", argent_actuel);
			request.setAttribute("categorieProjet", categorie_projet);
			request.setAttribute("dateCrea", dateCrea.substring(0, 10));
			request.setAttribute("dateLimite", dateLimite.substring(0, 10));
			request.setAttribute("idProjet", request.getParameter("id"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/detailprojet.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/accueil");
			rd.forward(request, response);
		}
	}

}
