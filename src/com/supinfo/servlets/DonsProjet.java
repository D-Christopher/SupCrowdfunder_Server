package com.supinfo.servlets;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.dao.jpa.JpaProjetDao;
import com.supinfo.entity.Projet;

/**
 * Servlet implementation class DonsProjet
 */
@WebServlet("/auth/don")
public class DonsProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonsProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("monId", id);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/auth/donsProjet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer)session.getAttribute("monId");
		JpaProjetDao projetDao = new JpaProjetDao(Persistence.createEntityManagerFactory("projet"));
		Projet projet = projetDao.getProjetById(id);
		int don = Integer.parseInt(request.getParameter("don"));
		int argent = projet.getArgent_actuel_projet() + don;
		projet.setArgent_actuel_projet(argent);
		projetDao.updateProjet(projet);
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/auth/donsProjet.jsp");
		rd.forward(request, response);*/
		response.sendRedirect("/SupCrowdfunder/accueil");
	}

}
