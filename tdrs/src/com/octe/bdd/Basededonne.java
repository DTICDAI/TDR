package com.octe.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.PrintWriter;


public class Basededonne {

	protected static Connection connexion;
	protected static Statement statutBD;
	protected static ResultSet resultat;
	
	
	private static String url = "jdbc:mysql://localhost/mission";
	private static String login = "root";
	private static String password = "";	
	
	/*private static String url = "jdbc:mysql://192.168.88.99:3306/mission";
	private static String login = "root";
	private static String password = "rootp@ss";*/	
	
	private static  String Connecter() throws ClassNotFoundException
	{	    		  		         
		try
		{			
			//chargement du driver
			connexion = null;					
			Class.forName("com.mysql.jdbc.Driver");	
			
			//connection à la base de données mysql
			connexion = DriverManager.getConnection(url, login, password);	
			System.out.println("Connecter");
	
			return connexion.getCatalog();			  
		}
		catch (SQLException e)
		{   
			System.out.println("CATCH ligne 44");
			return e.getMessage();			
		}	      
	}		
	
	protected static void FermerConnexion()
	{
		try
		{			 		 			  			    
			connexion.close();
		}
		catch(SQLException e)
		{			   	   
			javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());			
		}
	}	
	
	
	public String Inserer(String nomTableChamps, String nomChampsAInserer , String values) throws ClassNotFoundException
	{			
		String QueryString = "";	
		PreparedStatement prepart;
		String str = "",nomChamps = ""; // donne la requete		
	    int res = 1;	    
	    try
	    {	    	
	    	Connecter();	    			 
			//Enlever parenthèse gauche droite
	    	//System.out.println( "Les valeurs====> "  + values );
		 	if(!nomChampsAInserer.equals(""))
		 			nomChamps = " ( " + nomChampsAInserer + " ) ";
			//attribution des parametre pour la requete 
	    	QueryString = "INSERT INTO " + nomTableChamps +  nomChamps  + " VALUES (" + values + ")";	 	    	
	    	prepart = connexion.prepareStatement(QueryString);
	    	
	    	System.out.println( "INSERTIONNNNNNNNNNNNN :: "+ QueryString);
	    	
	    	/*for (int i = 0; i < n.length; i++) {
	    		prepart.setString(i+1,n[i]);
	         }  */  	
			prepart.executeUpdate(QueryString);
	    	//FermerConnexion();
	    	return "" + res + " sqll " + QueryString;
	    	
	    }
	    catch (SQLException e)
	    {
	    	FermerConnexion();	    	
	    	//	
	    	//System.out.println( "bdd ligne 84==><<< " + e.toString());
	    	return e.getMessage() + " : " + QueryString;
	    }			
	}
	
	
	public String Modifier(String nomTableChamps, String values, String condition) throws ClassNotFoundException
	{					
		int res = 1;
		String sql = "";				
		String nomChamp;		 
		String str = ""; // donne la requete			 			
		PreparedStatement prest;
			//System.out.println("ICI DANS MODIFIER ligne 100");			           
	    try
	    {
			Connecter();			
			// Statement instruction = connexion.createStatement();
			 sql = "update " + nomTableChamps + " set " + values + " where " + condition;	
			 System.out.println("sql == " + sql);
			//  prest = connexion.prepareStatement(sql);
			 
			 statutBD = connexion.createStatement();

			 statutBD.executeUpdate(sql);
			 				
			 FermerConnexion();
			 return "" + res;
	    }
	    catch (SQLException e)
	    {
	    	FermerConnexion();
	    	return e.getMessage() + " : " + sql;	    	
	    }			
	}
	//Suppression proprement dit
	public String Supprimer(String nomTable, String condition) throws ClassNotFoundException
	{			
		String QueryString = null;							 
	    int updateQuery = 0;        
	    try
	    {
	    	Connecter();
			statutBD = null;
			statutBD = connexion.createStatement();
			if (condition == "")
				QueryString = "DELETE FROM " + nomTable;
			else
				QueryString = "DELETE FROM " + nomTable + " WHERE " + condition;
			
	    	updateQuery = statutBD.executeUpdate(QueryString);
	    	FermerConnexion();
	    	return "" + updateQuery;	    
	    }
	    catch (SQLException e)
	    {
	    	//FermerConnexion();
	    	return QueryString;//e.getMessage();	    	
	    }			
	}
	
	//Recherche des elements
	public ResultSet Chercher(String nomTable, String nomChamp , String condition) throws ClassNotFoundException
	{			
		String QueryString = "" ;
		System.out.println("Chercher");
	    try
	    {
	    	
	    	Connecter();
			statutBD = null;
			statutBD = connexion.createStatement();			
			QueryString = "SELECT " + nomChamp + " FROM " + nomTable + " WHERE " + condition + "";
			 System.out.print( "ici ----=======><<<<<<<<<<<<< --------" + QueryString);	
			 statutBD.executeQuery(QueryString);
		     resultat = statutBD.getResultSet();		     
	       // FermerConnexion();
	         return resultat;
	    }
	    catch (SQLException e)
	    {
	    	FermerConnexion();	
	    	//out.print("ELSE EXCEPTION ligne 185" +e.getMessage());
	    	return resultat; 
	    	//throw new BasededonneeException("Impossible de se connecter à la base de données !! ");
	    }
	  
	}
	
	/*
	 *  Recherche pour le tableau de bord des congés
	 * 
	 */
	public ResultSet ChercherTB(String nomTable, String nomChamp , String condition) throws ClassNotFoundException
	{			
		String QueryString = null;
		
	    try
	    {
	    	//System.out.println("dans TRY ligne 171");
	    	Connecter();
			//statutBD = null;
			statutBD = connexion.createStatement();			
			QueryString = "SELECT " + nomChamp + " FROM " + nomTable + "";
			 System.out.print( "ici ----=======><<<<<<<<<<<<< --------" + QueryString);		
			 statutBD.executeQuery(QueryString);
		     resultat = statutBD.getResultSet();		     

	       // FermerConnexion();
         
	         return resultat;
	    }
	    catch (SQLException e)
	    {
	    	//FermerConnexion();	
	    //	System.out.print("ELSE EXCEPTION ligne 185" +e.getMessage());
	    	return resultat; 
	    	
	    	//throw new BasededonneeException("Impossible de se connecter à la base de données !! ");
	    }
	  
	}
	
	
	
	
	
	
	
	//Recherche des elements avec groupby
	public ResultSet ChercherGroupby(String nomTable, String nomChamp , String condition, String groupby) throws ClassNotFoundException
	{			
		String QueryString = null;
		
	    try
	    {
	    	//System.out.println("dans TRY ligne 171");
	    	Connecter();
			//statutBD = null;
			statutBD = connexion.createStatement();			
			QueryString = "SELECT " + nomChamp + " FROM " + nomTable + " WHERE " + condition + " GROUP BY " +  groupby + "";
			// System.out.print( "ici -------------" + QueryString);		
			 statutBD.executeQuery(QueryString);
		     resultat = statutBD.getResultSet();		     

	       // FermerConnexion();
         
	         return resultat;
	    }
	    catch (SQLException e)
	    {
	    	//FermerConnexion();	
	    //	System.out.print("ELSE EXCEPTION ligne 185" +e.getMessage());
	    	return resultat; 
	    	
	    	//throw new BasededonneeException("Impossible de se connecter à la base de données !! ");
	    }
	  
	}

	
	
}
