package com.octe.servlet.gestionentete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octe.bdd.GestionEntete;
import com.octe.form.GestionEnteteForm;

/**
 * Servlet implementation class AjoutEntete
 */
@WebServlet("/ModifEntete")
public class ModifEntete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String vue = "/WEB-INF/gestionentete/modifentete.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifEntete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionEntete gestionentete = new GestionEntete();
		
		
		//int id = Integer.parseInt(request.getParameter("id_entete"));
	    List<com.octe.beans.Entete> listexistEntete;	    
		try {											
			        listexistEntete = gestionentete.GetListEntete(" 1 and id_entete = " + request.getParameter("id_entete"));
			        //System.out.println("ModifEntete ligne 47---" + listexistEntete.get(0).getEntete());
					request.setAttribute("existentete", listexistEntete);
			
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + " ligne 68");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + " ligne 72");
			e.printStackTrace();
		}
			
		
		this.getServletContext().getRequestDispatcher(vue).forward(request,response);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		this.getServletContext().getRequestDispatcher("/listeentete").forward(request,response);
	}

}
