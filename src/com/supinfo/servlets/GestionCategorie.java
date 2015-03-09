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
import com.supinfo.entity.Categorie;

/**
 * Servlet implementation class GestionCategorie
 */
@WebServlet("/admin/gestioncategorie")
public class GestionCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
    	List<Categorie> categorieList = categorieDao.getAllCategorie();
		request.setAttribute("categorie", categorieList);
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		session.setAttribute("nbCategorie", categorieList.size());
		
		if(request.getParameter("id")!= null)
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			categorieDao.suprimerCategorieById(id);
			response.sendRedirect("/SupCrowdfunder/admin/gestioncategorie");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/gestioncategorie.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categorie nouvelle_categorie = new Categorie();
		nouvelle_categorie.setNom_categorie(request.getParameter("nouvelleCategorie"));
		JpaCategorieDao categorieDao = new JpaCategorieDao(Persistence.createEntityManagerFactory("projet"));
		categorieDao.createCategorie(nouvelle_categorie);
		response.sendRedirect("/SupCrowdfunder/admin/gestioncategorie");
	}

}
