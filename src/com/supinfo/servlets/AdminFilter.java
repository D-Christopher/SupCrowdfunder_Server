package com.supinfo.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter(urlPatterns={"/admin/*"})
public class AdminFilter implements Filter {


	/**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;         
        HttpSession session = request.getSession();
        boolean admin = false;
        
        try {
        	admin = (boolean)session.getAttribute("admin");
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        if(admin == false){
        	response.sendRedirect("/SupCrowdfunder/accueil");
        	return;
        }


		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */

	public void init(FilterConfig config) throws ServletException {

    }

}
