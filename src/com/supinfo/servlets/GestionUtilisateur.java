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

import com.supinfo.dao.jpa.JpaUtilisateurDao;
import com.supinfo.entity.Utilisateur;

/**
 * Servlet implementation class GestionUtilisateur
 */
@WebServlet("/admin/gestionutilisateur")
public class GestionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao(Persistence.createEntityManagerFactory("projet"));
    	List<Utilisateur> utilisateurList = utilisateurDao.getAllUtilisateur();
		request.setAttribute("utilisateur", utilisateurList);
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		session.setAttribute("nbUtilisateur", utilisateurList.size());
		
		if(request.getParameter("id")!= null)
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			utilisateurDao.suprimerUtilisateurById(id);
			response.sendRedirect("/SupCrowdfunder/admin/gestionutilisateur");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/gestionutilisateur.jsp");
			rd.forward(request, response);
		}
	}

}
