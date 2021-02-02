package com.octe.form;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;

import com.octe.bdd.Basededonne;

public class GestionEnteteForm extends Basededonne{
	
	/* 
	 * Vérifier doublon avant insertion dans la base de données	
	 */
	
	private String resultat;
	

	public static String addSlashes(String s) {
	    s = s.replaceAll("\\\\", "\\\\\\\\");
	    s = s.replaceAll("\\n", "\\\\n");
	    s = s.replaceAll("\\r", "\\\\r");
	    s = s.replaceAll("\\00", "\\\\0");
	    s = s.replaceAll("'", "\\\\'");
	    return s;
	}

	
	public String VerifierSaisie(HttpServletRequest request) throws SQLException, ClassNotFoundException{
		
		String logo = addSlashes(request.getParameter("logo"));
		String Entete = addSlashes(request.getParameter("Entete"));
		String Entete_droite = addSlashes(request.getParameter("Entete_droite"));
		
		
		String id_entete_amodif = request.getParameter("id_entete");
		
		
		
		System.out.println("ligne 23" + logo + " entete=== " + Entete + " ID_ENTETE===>" + id_entete_amodif + "<<<=====");
		if(logo.isEmpty() || Entete.isEmpty() || Entete_droite.isEmpty()){
			
			resultat = "Remplir les champs !! ";
		}
		else{System.out.println("CHAMPS NON VIDE");
			 Basededonne bdd = new Basededonne();
			 
			 
			 String values = "'"+  logo +"'" + "," + "'"+ Entete + "'" + "," + "'"+Entete_droite+"'";
			 String nomChamps = "logo,entete,entete_droite";
			 
			 /*
			  * 
			  *************************************************************************			SAISIE ENTETE
			  * 
			  */
			 if(id_entete_amodif == null){
					 try {
						 resultat = bdd.Inserer("entete", nomChamps, values);				
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						resultat = resultat + e.getMessage();
					}
					
					 
			 }
			 /*
			  **************************************************************************				 MODIFICATION ENTETE
			  */
			 
			 else if(id_entete_amodif != null){
					System.out.println(" ICI DANS MODIF ENTETE ----------------------------> ");
					 values =  " logo = '" + logo + "'" +  " , " + " entete = '" + Entete + "'" + " , " 
							  + " entete_droite = '" + Entete_droite + "'"  ;
					 
					bdd.Modifier("entete", values, " id_entete = " +  id_entete_amodif);
					System.out.println(" ICI DANS MODIF ENTETE ------------------------ligne 68----> ");
					
					
				}
				
		}
		return resultat;
	}
}
