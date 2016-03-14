package org.miage.sid.dao;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Etudiant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 n_etudiant serial NOT NULL,
 
 
  date_inscription date,
  
 
  
  nbr_annee_primaire integer,
  nbr_annee_college integer,

  dossier_scolaire character varying(100),
  arrivee_dossier integer,
  date_arrivee_dossier date,
  "login" character varying(100),
  pass character varying(100),
  hobbies character varying(200),
 
 
  
  
  n_inscription_origine character varying(20), ???
  num_order integer,   ???
  
  codebare character varying(100),
  
  remarque character varying(100),
  moyenne_reussi_college double precision,
  
  id_langue_etrangere integer,
  id_specialite integer,
  id_branche_prochaine integer,
	  
	 */
	 
	private String num_inscription;
	private String num_national;
	private String num_national_massar;
	private String num_carte_national;
	private String nom;
	private String prenom;
	
	@DateTimeFormat(pattern="yy-M-d")
	private Date date_naissance;
	private String lieu_naissance;
	private String sex;
	private String etat;
	
	@DateTimeFormat(pattern="yy-M-d")
	private Date date_etat;
	private String langue_2;
	private String dispence;
	private String bourse;
	private String niveau;
	private String specialite;
	private String delegation;
	
	
	private String ecole_originle;
	private String commune;
	private String parcours;
	
	private String photo;
	private String n_certificat_depart;
	
	@DateTimeFormat(pattern="yy-M-d")
	private Date  date_certificat_depart;
	
	 private int nbr_annee_1lycee;
	  private int nbr_annee_2lycee;
	  private int nbr_annee_3lycee;
	  
	  private String valeur_bourse_debut;
	  private String valeur_bourse_fin;
	  
	  @DateTimeFormat(pattern="yy-M-d")
	  private Date date_bourse;
	  private String n_bourse;
	  
		private int id_tuteur;
		private String etablis_prec;
		private int annee_scolaire;
		
		public Etudiant(){
			
			
		}
	  
	  public String getValeur_bourse_debut() {
		return valeur_bourse_debut;
	}

	public void setValeur_bourse_debut(String valeur_bourse_debut) {
		this.valeur_bourse_debut = valeur_bourse_debut;
	}

	public String getValeur_bourse_fin() {
		return valeur_bourse_fin;
	}

	public void setValeur_bourse_fin(String valeur_bourse_fin) {
		this.valeur_bourse_fin = valeur_bourse_fin;
	}

	public Date getDate_bourse() {
		return date_bourse;
	}

	public void setDate_bourse(Date date_bourse) {
		this.date_bourse = date_bourse;
	}

	public String getN_bourse() {
		return n_bourse;
	}

	public void setN_bourse(String n_bourse) {
		this.n_bourse = n_bourse;
	}

	
	
	
	
	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public int getNbr_annee_1lycee() {
		return nbr_annee_1lycee;
	}

	public void setNbr_annee_1lycee(int nbr_annee_1lycee) {
		this.nbr_annee_1lycee = nbr_annee_1lycee;
	}

	public int getNbr_annee_2lycee() {
		return nbr_annee_2lycee;
	}

	public void setNbr_annee_2lycee(int nbr_annee_2lycee) {
		this.nbr_annee_2lycee = nbr_annee_2lycee;
	}

	public int getNbr_annee_3lycee() {
		return nbr_annee_3lycee;
	}

	public void setNbr_annee_3lycee(int nbr_annee_3lycee) {
		this.nbr_annee_3lycee = nbr_annee_3lycee;
	}

	
	
	
	
	
	public int getId_tuteur() {
		return id_tuteur;
	}

	public void setId_tuteur(int id_tuteur) {
		this.id_tuteur = id_tuteur;
	}

	public String getEtablis_prec() {
		return etablis_prec;
	}

	public void setEtablis_prec(String etablis_prec) {
		this.etablis_prec = etablis_prec;
	}

	public int getAnnee_scolaire() {
		return annee_scolaire;
	}

	public void setAnnee_scolaire(int annee_scolaire) {
		this.annee_scolaire = annee_scolaire;
	}

	public String getNum_inscription() {
		return num_inscription;
	}


	
	public String getN_certificat_depart() {
		return n_certificat_depart;
	}

	public void setN_certificat_depart(String n_certificat_depart) {
		this.n_certificat_depart = n_certificat_depart;
	}

	public Date getDate_certificat_depart() {
		return date_certificat_depart;
	}

	public void setDate_certificat_depart(Date date_certificat_depart) {
		this.date_certificat_depart = date_certificat_depart;
	}

	public void setNum_inscription(String num_inscription) {
		this.num_inscription = num_inscription;
	}

   public Etudiant(String num1,String num2,String num3, String num4,String nom,String prenom,Date date_naissance,String lieu_naissance,
    		  String sex,String etat, Date date_etat, String langue_2, String dispense, String bourse,String filiere_pres,
    		  String specialite,String delegation, String ecole_originale,String commune,String parcours){
    	  
    	 this.num_inscription=num1;
    	 this.num_national=num2;
    	 this.num_national_massar=num3;
    	 this.num_carte_national=num4;
    	 this.nom=nom;
    	 this.prenom=prenom;
    	 this.date_naissance=date_naissance;
    	 this.lieu_naissance=lieu_naissance;
    	 this.sex=sex;
    	 this.etat=etat;
    	 this.date_etat=date_etat;
    	 this.langue_2=langue_2;
    	 this.dispence=dispense;
    	 this.bourse=bourse;
    	 this.niveau=filiere_pres;
    	 this.specialite=specialite;
    	 this.delegation=delegation;
    	 this.ecole_originle=ecole_originale;
    	 this.commune=commune;
    	 this.parcours=parcours;
    	 

		
	}
	
	


	public String getNum_national() {
		return num_national;
	}


	public void setNum_national(String num_national) {
		this.num_national = num_national;
	}





	public String getNum_national_massar() {
		return num_national_massar;
	}





	public void setNum_national_massar(String num_national_massar) {
		this.num_national_massar = num_national_massar;
	}





	public String getNum_carte_national() {
		return num_carte_national;
	}





	public void setNum_carte_national(String num_carte_national) {
		this.num_carte_national = num_carte_national;
	}
	




	public String getNom() {
		return nom;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public String getPrenom() {
		return prenom;
	}





	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}





	public Date getDate_naissance() {
		return date_naissance;
	}





	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}





	public String getLieu_naissance() {
		return lieu_naissance;
	}





	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}





	public String getSex() {
		return sex;
	}





	public void setSex(String sex) {
		this.sex = sex;
	}





	public String getEtat() {
		return etat;
	}





	public void setEtat(String etat) {
		this.etat = etat;
	}





	public Date getDate_etat() {
		return date_etat;
	}





	public void setDate_etat(Date date_etat) {
		this.date_etat = date_etat;
	}





	public String getLangue_2() {
		return langue_2;
	}





	public void setLangue_2(String langue_2) {
		this.langue_2 = langue_2;
	}





	public String getDispence() {
		return dispence;
	}





	public void setDispence(String dispense) {
		this.dispence = dispense;
	}





	public String getBourse() {
		return bourse;
	}





	public void setBourse(String bourse) {
		this.bourse = bourse;
	}





	public String getniveau() {
		return niveau;
	}





	public void setFiliere_pres(String niveau) {
		this.niveau = niveau;
	}





	public String getSpecialite() {
		return specialite;
	}





	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}





	public String getdelegation() {
		return delegation;
	}





	public void setN(String delegation) {
		this.delegation = delegation;
	}





	public String getEcole_originle() {
		return ecole_originle;
	}





	public void setEcole_originle(String ecole_originle) {
		this.ecole_originle = ecole_originle;
	}





	public String getcommune() {
		return commune;
	}





	public void setcommune(String j) {
		this.commune = commune;
	}





	public String getParcours() {
		return parcours;
	}





	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

}

