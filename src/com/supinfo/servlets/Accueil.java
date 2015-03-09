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
import com.supinfo.entity.Categorie;
import com.supinfo.entity.Projet;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
		Categorie macategorie = new Categorie();
		macategorie.setId_categorie(0);
    	List<Projet> projetList = projetDao.getProjet(macategorie);
    	List<Categorie> categorieList = categorieDao.getAllCategorie();
    	request.setAttribute("categorie", categorieList);
    	
    	// get session
    	HttpSession session = ((HttpServletRequest) request).getSession();
    	
    	// we need to add our list product as session variable
    	session.setAttribute("projet", projetList);
		
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_categorie_select = Integer.parseInt(request.getParameter("categorie"));
		Categorie macategorie = new Categorie();
		macategorie.setId_categorie(id_categorie_select);
		System.out.println(request.getParameter("categorie"));
			
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
    	List<Projet> projetList = projetDao.getProjet(macategorie);
    	List<Categorie> categorieList = categorieDao.getAllCategorie();
    	System.out.println(categorieList);
		
    	// get session
    	HttpSession session = ((HttpServletRequest) request).getSession();
    	
    	// we need to add our list product as session variable
    	session.setAttribute("projet", projetList);
    	request.setAttribute("categorie", categorieList);
		RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
		rd.forward(request, response);
	}

}
