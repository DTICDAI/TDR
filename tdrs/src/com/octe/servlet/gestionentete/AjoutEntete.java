package com.octe.servlet.gestionentete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octe.form.GestionEnteteForm;

/**
 * Servlet implementation class AjoutEntete
 */
@WebServlet("/AjoutEntete")
public class AjoutEntete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String vue = "/WEB-INF/gestionentete/ajoutentete.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutEntete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		this.getServletContext().getRequestDispatcher(vue).forward(request,response);
		System.out.println(response.toString());
			
		
		//this.getServletContext().getRequestDispatcher("/listeentete").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		GestionEnteteForm enteteform = new GestionEnteteForm();
		String resultat;
	
		try {
			resultat = enteteform.VerifierSaisie(request);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/listeentete").forward(request,response);
	}

}
