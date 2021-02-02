package com.octe.bdd; 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Entete
 * @param <from>
 */
@WebServlet("/entete")
public class Entete<from> extends HttpServlet {
	private static final long serialVersionUID = 1L;

		private static final String code = null;
	
		private String Vue = "/WEB-INF/liste.jsp";
		
		Basededonne bdd = new Basededonne();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GestionEntete entete = new GestionEntete();
		
		String condition = "1";
		
		
			try {
				request.setAttribute("listeentete",entete.GetListEntete(condition));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		this.getServletContext().getRequestDispatcher( Vue ).forward( request, response );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String textarea = request.getParameter("textarea");
		PrintWriter writer = response.getWriter();
	
		this.getServletContext().getRequestDispatcher( "Vue" ).forward( request, response );
		
	}
	
	
}
