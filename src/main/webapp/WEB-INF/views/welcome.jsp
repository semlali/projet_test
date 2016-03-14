<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>WELCOME</title>

<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-ui/jquery-ui-1.8.10.custom.min.js" />"></script>	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	

<script type="text/javascript">
               
                        
                        //document.getElementById("champ_cache").style.display = "none";
                        document.form.champ_cache.disabled=true;
                        function afficher()
                        {
                        	 document.form.champ_cache.disabled=false;
                        }
                        function cacher()
                        {
                        	 document.form.champ_cache.disabled=true;
                        }
                        
                      
                       
                        
                        function myFunction() {
                            var x = document.getElementById("mySelect").value;
                            document.getElementById("demo").innerHTML = "You selected: " + x;
                        
                        
                        if((x=="r"))
                 	   {
                 		document.form.certificat_cache.disabled=false;
                     	 }	
                                       
                       
                        	else
                        	{   document.form.certificat_cache.disabled=true;
                            	 }
                        	
                        }
                        
                     
            
  </script>
     
  <script type="text/javascript" charset="utf-8">
             //select qui depend de lautre

     function getStates(){
       
    	 $.getJSON(
                 "stateslist.html", 
                 {niveau: $("select#niveau").val()},
                 function(data) {
                      var html = '';
                      html = '<option value="">ppppp</option>';
                       
                      for(var i=0; i<data.length; i++){
                           html += '<option value="' + data.get(i) + '">' + data.get(i) + '</option>';
                       }
                      $("select#branche").append(html);
                 });
    	 alert(data.lenght);
           }
             
   
      $(document).ready(function() {
         $("select#niveau").change(function()
          {
        	 getStates();
          });
      });
</script>
  
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}
</style>

</head>
<body>${message}
 
	<br>
	<br>
	 <h2>liste etudiants</h2>
	 <b>Change the Country State Change By Ajax</b>
	  <br><br> Country: <select id="country" name="country">
	   <option value="select">Select Country</option> 
	  <option value="india">India</option> <option value="usa">USA</option> 
	  </select>
	  <br><br> State: <select id="state" name="state">
	   </select>
	 
	
	<div style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;">
	  
        <h2>AJOUTER ETUDIANT</h2> 
	</div>
	<br><br>
	<sf:form id="form" name="form" method="get" modelAttribute="etudiant" action="saveEtudiant">
	
	 <table>
	  
    <tr>
	  <td>Numéro d'inscription :</td>
	  <td><input path="num_inscription" name="num_inscription" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  <td>Numéro National :</td>
	  <td><input path="num_national" name="num_national" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  <td><input type="radio" name="radio" id="radio" > <label for="radio">Dèrnier numéro national</label>
	  <td>
	  <fieldset> <legend><h3>Parcours scolaire de l'étudiant</h3></legend>
	  <table>
	   <tr><td><input path="nbr_annee_1lycee" name="nbr_annee_1lycee" min="0" max="10" id="nbr_annee_1lycee" placeholder="nombre d'année en 5eme" />

       <tr><td><input path="nbr_annee_2lycee" name="nbr_annee_2lycee" min="0" max="10" id="nbr_annee_2lycee" placeholder="nombre d'année en 6eme" /> 

       <tr><td><input name="nbr_annee_3lycee" path="nbr_annee_3lycee" min="0" max="10" id="nbr_annee_3lycee" placeholder="nombre d'année en bac" /> 

	  </table>
	  </fieldset>
	  
	  </td>
	  <td><input name="photo" path="photo" type="file" style="width:200px; font-size:10px; color:red;" /></td>
	   
    </tr>
   
   
   
    <tr>
	  <td>Numéro national MASSAR :</td>
	  <td><input path="num_national_massar" name="num_national_massar" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  <td>Numéro de carte nationale	:</td>
	  <td><input path="num_carte_national" name="num_carte_national" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  <td></td>
    <td><a href="#" id="myBtn"   style="color:red; font-weight:bold; padding:5px 10px;">Ajouter parents</a></td>
    <td><input name="parent" value="${mes}" disabled/></td>
   
    
    
    </tr>
     </table>
	
	<fieldset>
	<legend>
	  <h3> INFORMATION SUR L'ETUDIANT</h3> 
	</legend>
	<table>
	<tr>
	  <td>Nom :</td>
	  <td><input name="nom" path="nom" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  <td>Prénom :</td>
	  <td><input name="prenom" path="prenom" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
    </tr>
  
    <tr>
    <td>Date de Naissance</td>
    <td><input path="date_naissance" name="date_naissance" type="date"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;"/></td>
    <td>Sex :
    </td>
    <td>
    <input id="rad1" path="sex" name="sex" type="radio" value="garçon" /> 
<label for="rad1">Garçon</label> 

<input id="rad2" path="sex" name="sex" type="radio" value="fille" /> 
<label for="rad2">Fille</label>
    </td>
   
    </tr>
    <tr>
    <td>Lieu de Naissance</td>
    <td><input path="lieu_naissance" name="lieu_naissance" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
    </tr>
    <tr>
    <td>Etat</td>
	<td><select  id="mySelect" onChange="myFunction()" path="etat" name="etat" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <option value="rafid" id="rafid" >رافد</option> 
        <option value="wafid" id="wafid"  >وافد</option>
        <option value="m" id="m" >مدمج</option>
        
    </select><td><p id="demo"></p>
    
    <td>Date Etat</td>
    <td><input type="date" path="date_etat" name="date_etat"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
    
     </tr>
     
     <tr>
      
      <td>Deuxième langue étrangére : </td>
      <td>
    <select path="langue_2" name="langue_2" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <c:forEach items="${langues}" var="l">
        <option value="${l}" > 
         ${l} </option>
        </c:forEach>
        
   
    </select>
    </td>
    
     <td><label>Dispense</label>
     
	  <input path="dispense" id="oui" type="radio" name="dispence"  value="oui"> <label for="radio">Oui</label>
	  <input path="dispense" id="non" type="radio" name="dispence" value="non"> <label for="radio">Non</label>
	  </td>
	
	  
	  <td><td>Bourse 
	  <input type="radio" path="bourse" name="bourse" value="oui" id="oui" onClick="afficher();" checked="checked"> <label for="radio">Oui</label>
	  <input type="radio" path="bourse" name="bourse" value="non" id="non" onClick="cacher();"> <label for="radio">Non</label>
	  </td>
	  <td>
	  <fieldset id="champ_cache">
	  <table>
	  <tr><td><label>Num bourse</label><input value="" path="n_bourse" name="n_bourse"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" />
	  <tr><td><label>Valeur bourse debut</label><input value="" path="valeur_bourse_debut" name="valeur_bourse_debut"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" />
	   <tr><td><label>Valeur bourse fin</label><input value="" path="valeur_bourse_fin" name="valeur_bourse_fin"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" />
	  <tr><td><label>Date bourse</label><input type="date" value="" path="date_bourse" name="date_bourse"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" />
	  </table>
	  </fieldset>
	  </tr>
	</table>
	</fieldset>
	<fieldset>
	<table>
	  <tr>
	  <td>Filière précedente : </td>
      <td>

    <select path="niveau" onchange="javascript:itemFocus('submit');" name="niveau" id="niveau" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
       <option value="0" selected>-- choisissez un niveau</option>
        <c:forEach items="${niveau}" var="b">
        <option value="${b}">${b}</option>
        </c:forEach>
        
   
    </select>
    </td>
    
    <td>

<select name="branche"  id="branche">
<option value="0" selected>-- choisissez une branche</option>

</select>
    </td>
	  </tr>
	  <tr>
	  <td>Spésialité</td>
	   <td>
       <select path="specialite" name="specialite" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <c:forEach items="${specialites}" var="s">
        <option value="${s}">${s}</option>
        </c:forEach>
       </select>
     </td>
	  </tr>
	  <tr>
	  <td>Délégation</td>
	  <td>
       <select path="delegation" name="delegation" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <c:forEach items="${delegations}" var="d">
        <option value="${d}">${d}</option>
        </c:forEach>
         </select></td>
	  </tr>
	  <tr>
	  <td>Ecole originale</td>
	  <td>
       <select path="ecole_originle" name="ecole_originle" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <c:forEach items="${etablissements}" var="eta">
        <option value="${eta}">${eta}</option>
        </c:forEach>
       </select>
     </td>
       <td></td>
     </tr>
	  <tr>
	  <td>Commune</td>
	   <td>
    <select path="langue_2" name="langue_2" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;">
        <c:forEach items="${communes}" var="c">
        <option value="${c}">${c}</option>
        </c:forEach>
        
   
    </select>
    </td>
    
	  </tr>
	  </table>
	
	</fieldset>
	 <td>
	 <fieldset id="certificat_cache" > <legend><h3>Certificat de départ</h3></legend>
	  <table>
	   <tr>
	    <td>En attendant le certificat de départ</td>
	    <td><input  type="radio" name="depart" id="radio" value="oui"/> <label for="radio">Oui</label>
	    <input  type="radio" name="depart" id="radio"   value="non"/> <label for="radio">Non</label></td>
	   </tr>
	   <tr>
	    <td>Numéro d'inscription précedent</td>
	    <td><input value="" name="numInscprecedent"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	    
	   </tr>
	   <tr>
	    <td>Numéro de certificat de départ</td>
	    <td><input value="" name="numCertprecedent"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	    
	   </tr>
	   <tr>
	    <td>Date de certificat de départ</td>
	    <td><input type="date" name="datedepart"  style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	    
	   </tr>
	  </table>
	</fieldset>
	 </td>
	 <table>
	  <tr><td></td><td></td>
	  <td><input type="submit" value="Submit !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	  <td><input type="reset" value="Reset !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	  </tr>
	  </table>
		
	</sf:form>
	
		
    <!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content ajouter parent -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">×</span>
      <h2>Ajouter Parent</h2>
    </div>
    <div class="modal-body">
      <form method="get" modelAttribute="tuteur">
     <table>
	  
    <tr>
    
	  <td>Nom :</td>
	  <td><input name="nom" path="nom" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	  
	  <tr>
	  <td>Prénom :</td>
	  <td><input name="prenom" path="prenom" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  </tr>
	  
	  
	  </table>
	  
	  <fieldset> <legend>Sex</legend>
	  <table>
	  <tr>
	  
	  <td><input type="radio" name="sex" path="sex" required id="radio" > <label for="radio">femme</label>
	  <td><input type="radio" name="sex" id="sex" required > <label for="radio">homme</label>
	  
	 </tr>
	 </table>
	  
     </fieldset>
     
	  <table>
	   
	  <tr>
	  <td>Relation familiale</td>
     <td><select name="relation" path="relation" required >
        <option value="p">Pére</option>
        <option value="m">Mère</option>
        <option value="o">Oncle</option>
        
    </select>
    </td>
    </tr>
    <tr>
    
	  <td>Adress :</td>
	  <td><textarea name="adress" required path="adress" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;"  >ENTER ADRESS</textarea></td>
	  
	</tr>
	<tr>
    
	  <td>Tel mobile:</td> <td><label>+212(0)6</label>
	  <input name="telmobile" path="telmobile" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	
	<tr>
    
	  <td>Tel fix:</td> <td><label>+212(0)5</label>
	  <input name="telfix" path="telfix" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Ville :</td> 
	  <td><input name="ville" path="ville" required="required" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Email :</td>
	  <td><input name="email" path="email" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Travail :</td>
	  <td><input name="travail" name="travail" required style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	
     <tr>
	  <td><input type="submit" value="Submit !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	  <td><input type="reset" value="Reset !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	 </tr>
	</table>
	
		</form>
    </div>
    <div class="modal-footer">
      <h3>megacom</h3>
    </div>
  </div>

</div>
	
<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>