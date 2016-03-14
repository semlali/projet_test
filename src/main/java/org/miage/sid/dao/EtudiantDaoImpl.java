package org.miage.sid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;



public class EtudiantDaoImpl implements IEtudiantDao {
	
	private Map<String,Etudiant> etudiants = new HashMap<String, Etudiant>();
	private Map<String,Tuteur> tuteurs = new HashMap<String, Tuteur>();
	private Map<Integer,String> Langues = new HashMap<Integer, String>();
	
	Logger logger = Logger.getLogger(EtudiantDaoImpl.class);
	 int IdLangue; //
	 int IdBranche;
	 int IdDelegation; //
	 int idSpecialite; //
	 int idEtablissementpres; //
	
	private static int id_tuteur;
	private static String nom_tuteur;
	
		public void ajouterEtudiant(Etudiant e) {
			System.out.println("debut insertion etudiant!! ");
			//ajouter etudiant a la base de donn�e
			
			 setId_tuteur(getIdNew());
			 
			 
			Connection conn;
			
			
			 PreparedStatement pre;
			
			 ResultSet resultat;
			 
			 // get id langue
			 String  nom_Langue = null;
			 int  key;
			   try{
					 conn=connexion();
					 pre=(PreparedStatement) conn.prepareStatement("select * from langue_etrangere");
					 
					 System.out.println("requete id de langue :"+pre);
					 resultat=pre.executeQuery();
					 
					 while (resultat.next()) {
						   
						   nom_Langue=resultat.getString("nom_langue_etrangere");
						   System.out.println("NOM de langue :"+e.getLangue_2());
						   if(nom_Langue.equals(e.getLangue_2())){
							   IdLangue=resultat.getInt("id_langue_etrangere");  
							   System.out.println("id de langue :"+IdLangue);
						   }
						   
						 //Langues.put(IdLangue, nom_Langue);
						 
						   
						}
					 conn.close();			 
				 }catch(Exception ex){
					 System.out.println(ex);
				 }
			  
			   
					
					// get id etablissement
					  try{
										 conn=connexion();
										 pre=(PreparedStatement) conn.prepareStatement("select id_etablissement from etablissement_precedente"
										 		+ "where nom_etabli="+e.getEtablis_prec());
										 resultat=pre.executeQuery();
										 
										 while (resultat.next()) {
											   
											   idEtablissementpres=resultat.getInt(1); 
											   
											}
	conn.close();			 
					 }catch(Exception ex){
						 System.out.println(ex);
					 }
					  
					  
					// get id specialite
					   try{
							 conn=connexion();
							 pre=(PreparedStatement) conn.prepareStatement("select id_spec from specialisation"
							 		+ "where designation_spec="+e.getSpecialite());
							 resultat=pre.executeQuery();
							 
							 while (resultat.next()) {
								   
								   idSpecialite=resultat.getInt(1); 
								   
								}
							 conn.close();			 
						 }catch(Exception ex){
							 System.out.println(ex);
						 }
					   
					// get id delegation
					   try{
							 conn=connexion();
							 pre=(PreparedStatement) conn.prepareStatement("select n_delegation from delegation"
							 		+ "where libelle_deleg_ara="+e.getdelegation());
							 resultat=pre.executeQuery();
							 
							 while (resultat.next()) {
								   
								   idSpecialite=resultat.getInt(1); 
								   
								}
							 conn.close();			 
						 }catch(Exception ex){
							 System.out.println(ex);
						 }
					   
					   
							 
							 
				    
			   
			   
			 
			 
			 try{
				 conn=connexion();
	 String query = "INSERT INTO etudiant (n_etudiant,n_national,n_national_massar,cin,nom_etudiant,prenom_etudiant,date_naissance,"
	 		+ "lieu_naissance,sexe,etat_etudiant,date_etat_etudiant,id_langue_etrangere,"
	 		+ "dispense,bourse,id_branche_precedente,id_specialite,id_tuteur,etablis_prec,photo,nbr_annee_1lycee,nbr_annee_2lycee,nbr_annee_3lycee,"
	 		+ "n_bourse,valeur_bourse_debut,valeur_bourse_fin,date_bourse,n_inscription)"
	 		+ " VALUES (?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
	 System.out.println("insertion tuteur!! "+query);		 
	 
	 java.util.Date utilDateNaissance = e.getDate_naissance();
	    java.sql.Date sqlDateNaissance = new java.sql.Date(utilDateNaissance.getTime());
	    System.out.println("utilDate de naissance :" + utilDateNaissance);
	    System.out.println("sqlDate de naissance :" + sqlDateNaissance);
	    
	    java.util.Date utilDateEtat = e.getDate_etat();
	    java.sql.Date sqlDateEtat = new java.sql.Date(utilDateEtat.getTime());
	    System.out.println("utilDate de etat :" + utilDateEtat);
	    System.out.println("sqlDate de etat :" + sqlDateEtat);
	    
	    java.util.Date utilDateBourse = e.getDate_bourse();
	    java.sql.Date sqlDateBourse = new java.sql.Date(utilDateBourse.getTime());
	    System.out.println("utilDate de etat :" + utilDateBourse);
	    System.out.println("sqlDate de etat :" + sqlDateBourse);
	    
	    
			 pre=(PreparedStatement) conn.prepareStatement(query);
			   pre.setInt(1, getIdNewEtudiant());
			   pre.setString(2, e.getNum_national());
		       pre.setString(3, e.getNum_national_massar());
		       pre.setString(4, e.getNum_carte_national());
		       pre.setString(5, e.getNom());
		       pre.setString(6, e.getPrenom());
		       pre.setDate(7, sqlDateNaissance);
		       pre.setString(8, e.getLieu_naissance());
		       pre.setString(9, e.getSex());
		       pre.setString(10, e.getEtat());
		       pre.setDate(11,sqlDateEtat );
		       pre.setInt(12, IdLangue); //id de langue  getLangue_2()
		       pre.setString(13, e.getDispence());
		       pre.setString(14, e.getBourse());
		       pre.setInt(15, IdBranche); //id  getFiliere_pres
		       pre.setInt(16,idSpecialite ); //id   getSp�cialite
		       pre.setInt(17, getIdNew()-1);  //id_tuteur
		       //pre.setString(17, IdDelegation);   //id delegation
		       pre.setInt(18, idEtablissementpres);
		       pre.setString(19, e.getPhoto());
		       pre.setInt(20, e.getNbr_annee_1lycee());
		       pre.setInt(21, e.getNbr_annee_2lycee());
		       pre.setInt(22, e.getNbr_annee_3lycee());
		       pre.setString(23, e.getN_bourse());
		       pre.setDouble(24, Double.parseDouble(e.getValeur_bourse_debut()));
		       pre.setDouble(25, Double.parseDouble(e.getValeur_bourse_fin()));
		       pre.setDate(26, sqlDateBourse);
		       
		       pre.setString(27, e.getNum_inscription());
		       
				 pre.executeQuery();
				 
				 System.out.println("fin insertion etudiant!! ");
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
	
			 
			etudiants.put(e.getNom(), e);
			System.out.println("ajouter etudiant!! "+e.getDate_naissance());
			System.out.println("valeur photo!! "+e.getPhoto());
		}
		
		public List<Etudiant> getAllEtudiant(){
			Collection<Etudiant> etu=etudiants.values();
			return new ArrayList<Etudiant>(etu);
			
		}
	
        public void init(){ //pour alimenter la liste
        	logger.info("Initialisation du etudiant");
        	ajouterEtudiant(new Etudiant("12","124","555","1235","samia","semlali",null,"Marrakech","femme",
        	 "etat1",null,"fran�ais","oui","non","physique","spec","niaba1","sebti","jama3a","info"));
        	
        	
        }

        Connection conn=null;
		  String url = "jdbc:postgresql://localhost:5432/GESMA_LYCEE";
		  String user = "postgres";
		  String passwd = "adminsql";

		  
		@Override
		public Connection connexion() {
			// TODO connexion
			
			 try {
			    		  
			    		    Class.forName("org.postgresql.Driver");
			    		    conn = DriverManager.getConnection(url, user, passwd);
			    		    
			    		    System.out.println("succesfully connected !!");

			    		  } catch (Exception e) {
			    		    e.printStackTrace();
			    	
			    		 }    
			    	  return conn;
		        }

		@Override
		public List<String> getLangue() {
			// TODO recuperer etat
			
			
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from langue_etrangere");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("nom_langue_etrangere"));
					
					   
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 
			
			 
			 System.out.println("method get langue");
			 
			return list;
			    
			
			}
		
		@Override
		public List<String> getBranche() {
			// TODO recuperer etat
			
			
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from branche");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("nom_brance"));
					   
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get branche");
			 
			return list;
			    
			
			}
		  
		  @Override
			public List<String> getDelegation() {
				// TODO recuperer etat
				
				
				List<String> list=new ArrayList<String>();
				
				 Connection conn;
				 PreparedStatement pst;
				
				 ResultSet resultat; 
				 try{
					 conn=connexion();
					 pst=(PreparedStatement) conn.prepareStatement("select * from delegation");
					 resultat=pst.executeQuery();
					 
					 while (resultat.next()) {
						   list.add(resultat.getString("libelle_deleg_ara"));
						   
						}
					 
					 
				     conn.close();			 
				 }catch(Exception ex){
					 System.out.println(ex);
				 }
				 System.out.println("method get delegation");
				 
				return list;
				    
				
				}


		@Override
		public List<String> getEtablissement() {
			// TODO recuperer etablissement
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from etablissement_precedente");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("nom_etabli"));
					  
					   
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get etablissement");
			 
			return list;
			
		}
        
		
		public int  getIdNew() {
			
			 Connection conn;
			 PreparedStatement pst;
			 int id = 0;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select max(id_tuteur) from tuteur");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   id=resultat.getInt(1);
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get id tuteur"+id+1);
			 return  id+1;
			 
		}
		
		public int  getIdNewEtudiant() {
			
			 Connection conn;
			 PreparedStatement pst;
			 int id = 0;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select max(n_etudiant) from etudiant");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   id=resultat.getInt(1);
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get id etudiant"+id+1);
			 return  id+1;
			 
		}
		
		@Override
		public void DeleteTuteur() {

			 Connection conn;
			 PreparedStatement pst;
			
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("delete from tuteur where id_tuteur="+id_tuteur);
				 resultat=pst.executeQuery();
				 
				 
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("delete tuteur"+id_tuteur);
			
		
			
			
			
		} 
		
		@Override
		public void ajouterTuteur(Tuteur t) {
			// TODO Auto-generated method stub
			
			
			
			
			tuteurs.put(t.getNom(), t);
			System.out.println("ajouter tuteur!! "+t.getNom());
			
			Connection conn;
			
			
			 PreparedStatement pre;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
	 String query = "INSERT INTO tuteur (id_tuteur,nom_tuteur,prenom_tuteur,relation_tuteur,adresse_tuteur,teleph_tuteur,ville_tuteur,email_tuteur"
	 		+ ",sexe_tuteur,profession_tuteur,teleph_tuteur_fix) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 System.out.println("insertion tuteur!! "+query);		 
			 pre=(PreparedStatement) conn.prepareStatement(query);
			   pre.setInt(1, getIdNew());
			   pre.setString(2, t.getNom());
		       pre.setString(3, t.getPrenom());
		       pre.setString(4, t.getRelation());
		       pre.setString(5, t.getAdress());
		       pre.setString(6, t.getTelmobile());
		       pre.setString(7, t.getVille());
		       pre.setString(8, t.getEmail());
		       pre.setString(9, t.getSex());
		       pre.setString(10, t.getTravail());
		       pre.setString(11, t.getTelfix());
		       
		       
				 pre.executeQuery();
				 
				 System.out.println("insertion tuteur!! ");
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			
			
		}

		public static int getId_tuteur() {
			return id_tuteur;
		}

		public static void setId_tuteur(int id_tuteur) {
			EtudiantDaoImpl.id_tuteur = id_tuteur;
		}

		@Override
		public List<String> getSpecialite() {
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from specialite");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("nom_specialite"));
					  
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get specialite");
			 
			return list;
			 
		}

		@Override
		public List<String> getCommune() {
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from commune");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("libelle_com_ara"));
					
					   
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 
			
			 
			 System.out.println("method get commune");
			 
			return list;
			    
			
		}

		public static String getNom_tuteur() {
			return nom_tuteur;
		}

		public static void setNom_tuteur(String nom_tuteur) {
			EtudiantDaoImpl.nom_tuteur = nom_tuteur;
		}

		@Override
		public List<String> getNiveau() {
			List<String> list=new ArrayList<String>();
			
			 Connection conn;
			 PreparedStatement pst;
			
			 ResultSet resultat; 
			 try{
				 conn=connexion();
				 pst=(PreparedStatement) conn.prepareStatement("select * from niveau_scolaire");
				 resultat=pst.executeQuery();
				 
				 while (resultat.next()) {
					   list.add(resultat.getString("niveau_scolaire"));
					   
					}
				 
				 
			     conn.close();			 
			 }catch(Exception ex){
				 System.out.println(ex);
			 }
			 System.out.println("method get niveau scolaire");
			 
			return list;
			    
			
		}

		 
		
		
	
        
}
