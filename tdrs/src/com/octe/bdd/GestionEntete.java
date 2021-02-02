package com.octe.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.octe.beans.Entete;

public class GestionEntete extends Basededonne {

	
	public ArrayList<Entete> GetListEntete(String condition) throws ClassNotFoundException,SQLException{
	
		Basededonne bdd = new Basededonne();
		
		ArrayList<Entete> listeentete = new ArrayList<Entete>();
		ResultSet resultat_sql;
		
		
		resultat_sql = bdd.Chercher("Entete", "id_entete,entete,etat,logo,entete_droite", condition);
		System.out.println(resultat_sql);
		try{
			while(resultat_sql.next()){
				
				Entete entet = new Entete();
				
				entet.setEntete(resultat_sql.getString("entete"));
				entet.setEtat(resultat_sql.getString("etat"));
				entet.setId_entete(resultat_sql.getInt("id_entete"));
				entet.setLogo(resultat_sql.getString("logo"));
				entet.setEntete_droite(resultat_sql.getString("entete_droite"));
				
				listeentete.add(entet);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage() + " Erreur !!! ");
		}
		
		
		return listeentete;

	}
	
}
