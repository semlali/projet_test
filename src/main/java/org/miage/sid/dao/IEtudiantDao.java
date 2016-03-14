package org.miage.sid.dao;

import java.sql.Connection;
import java.util.List;


public interface IEtudiantDao {
	    public Connection connexion();
	    public List<String> getLangue();
	    public List<String> getBranche();
	    public List<String> getNiveau();
	    public List<String> getDelegation();
	    public List<String> getSpecialite();
	    public List<String> getCommune();
	    public List<String> getEtablissement();
		public void ajouterEtudiant(Etudiant e);
		public void DeleteTuteur();
		public List<Etudiant> getAllEtudiant();
		public void ajouterTuteur(Tuteur t);


}
