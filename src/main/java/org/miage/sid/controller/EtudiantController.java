package org.miage.sid.controller;


import java.util.ArrayList;
import java.util.List;

import org.miage.sid.dao.Etudiant;
import org.miage.sid.dao.EtudiantDaoImpl;
import org.miage.sid.dao.Tuteur;
import org.miage.sid.metier.EtudiantMetierImpl;
import org.miage.sid.metier.IEtudiantMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//ajouter header
//modificer le controller

@Controller
public class EtudiantController {
	
	@Autowired
	private IEtudiantMetier metier;
	
	/*@RequestMapping(value="/index")
	public String index(Model model){
		
		model.addAttribute("etudiants",metier.getAllEtudiant());
		return "etudiants";
	}*/
	
	@RequestMapping("/")
	public ModelAndView affichier(Model model) {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>*****HEADER*****</h3>This message is coming from Controller .java **********</div><br><br>";
		
		model.addAttribute("etudiant",new Etudiant());  //model associ� a la vue formulaire d'ajout d'etudiant
		model.addAttribute("etudiants",metier.getAllEtudiant());
		model.addAttribute("langues", metier.getLangue());
		model.addAttribute("branches", metier.getBranche());
		model.addAttribute("niveau", metier.getNiveau());
		model.addAttribute("etablissements",metier.getEtablissement());
		model.addAttribute("delegations", metier.getDelegation());
		model.addAttribute("communes", metier.getCommune());
		model.addAttribute("specialites", metier.getSpecialite());
		model.addAttribute("tuteur", new Tuteur());
		
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/saveEtudiant")
	public String save(Model model,Etudiant e,Tuteur t) {
		 metier.ajouterEtudiant(e);
		 metier.ajouterTuteur(t);
		
		
		 model.addAttribute("tuteur",new Tuteur());
		 model.addAttribute("etudiant",new Etudiant());  //model associ� a la vue formulaire d'ajout d'etudiant
		 model.addAttribute("etudiants",metier.getAllEtudiant());
		 model.addAttribute("langues",metier.getLangue());
		 model.addAttribute("branches", metier.getBranche());
		 model.addAttribute("niveau", metier.getNiveau());
		 model.addAttribute("etablissements",metier.getEtablissement());
		 model.addAttribute("delegations", metier.getDelegation());
		 model.addAttribute("specialites", metier.getSpecialite());
		 model.addAttribute("communes", metier.getCommune());
			
		return "welcome"; 
      
	}
	
	
	@RequestMapping("/deleteTuteur")
	public void delete(Model model,Etudiant e,Tuteur t) {
		      metier.DeleteTuteur();
		}
	
	@RequestMapping(value="stateslist.html")
	   public @ResponseBody List<String> sectionList(@ModelAttribute("etudiant") Etudiant etudiant, @RequestParam(value="niveau", required=true) String niveau){
	    
		List<String> list= new ArrayList<String>();
	    list.add("souso");
	    list.add("mou");
	    System.out.println("list contient: "+niveau);
		return list;
		
	   }
	

	
	@RequestMapping("/saveTuteur")
	public void save(Tuteur t,Model model) {
		
		
		
		//String mes = "parent: "+EtudiantDaoImpl.getNom_tuteur()+" avec id: "+EtudiantDaoImpl.getId_tuteur();
		
			
			model.addAttribute("tuteur",new Tuteur());
			model.addAttribute("etudiant",new Etudiant());  //model associ� a la vue formulaire d'ajout d'etudiant
			model.addAttribute("etudiants",metier.getAllEtudiant());
			model.addAttribute("langues", metier.getLangue());
			model.addAttribute("etablissements",metier.getEtablissement());
			model.addAttribute("branches", metier.getBranche());
			
			model.addAttribute("niveau", metier.getNiveau());
			model.addAttribute("delegations", metier.getDelegation());
			model.addAttribute("specialites", metier.getSpecialite());
			model.addAttribute("communes", metier.getCommune());
			 
		
		
 
		
	}
	
	

}
