package org.miage.sid.metier;

import java.sql.Connection;
import java.util.List;

import org.miage.sid.dao.Etudiant;
import org.miage.sid.dao.Tuteur;



public interface IEtudiantMetier {
	public void ajouterEtudiant(Etudiant e);
	public List<String> getLangue();
	public List<String> getBranche();
	public List<String> getDelegation();
	public List<String> getSpecialite();
	public List<String> getEtablissement();
	public List<Etudiant> getAllEtudiant();
	public List<String> getCommune();
	public List<String> getNiveau();
	public Connection connexion();
	public void ajouterTuteur(Tuteur t);
	public void DeleteTuteur();
}
