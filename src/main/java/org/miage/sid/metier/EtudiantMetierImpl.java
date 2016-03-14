package org.miage.sid.metier;

import java.sql.Connection;
import java.util.List;

import org.miage.sid.dao.Etudiant;
import org.miage.sid.dao.IEtudiantDao;
import org.miage.sid.dao.Tuteur;



public class EtudiantMetierImpl implements IEtudiantMetier{
	
	 private IEtudiantDao dao; 
	 
	 //seter pour l'injection des dépendances dans le fichier de conf
	    public void setDao(IEtudiantDao dao) {
			this.dao = dao;
		}
	    
	    
		@Override
		public void ajouterEtudiant(Etudiant e) {
			dao.ajouterEtudiant(e);
			
		}


		@Override
		public List<Etudiant> getAllEtudiant() {
			return dao.getAllEtudiant();
			
		}


		@Override
		public Connection connexion() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public List<String> getLangue() {
			return dao.getLangue();
			
		}


		@Override
		public List<String> getEtablissement() {
			// TODO Auto-generated method stub
			return dao.getEtablissement();
		}


		@Override
		public void ajouterTuteur(Tuteur t) {
			// TODO Auto-generated method stub
			dao.ajouterTuteur(t);
		}


		@Override
		public List<String> getBranche() {
			// TODO Auto-generated method stub
			return dao.getBranche();
		}


		@Override
		public List<String> getDelegation() {
			// TODO Auto-generated method stub
			return dao.getDelegation();
		}


		@Override
		public List<String> getSpecialite() {
			// TODO Auto-generated method stub
			return dao.getSpecialite();
		}


		@Override
		public List<String> getCommune() {
			// TODO Auto-generated method stub
			return dao.getCommune();
		}


		@Override
		public void DeleteTuteur() {
			dao.DeleteTuteur();
			
		}


		@Override
		public List<String> getNiveau() {
			
			return dao.getNiveau();
		}


		

}
