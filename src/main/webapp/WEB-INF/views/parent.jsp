<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Parent</title>
</head>
<body>
<form method="post" modelAttribute="parent" ></form>
     <table>
	  
    <tr>
    
	  <td>Nom :</td>
	  <td><input value="sans" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	  
	  <tr>
	  <td>Prénom :</td>
	  <td><input value="" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  </tr>
	  
	  
	  </table>
	  
	  <fieldset> <legend>Sex</legend>
	  <table>
	  <tr>
	  
	  <td><input type="radio" name="radio" id="radio" > <label for="radio">femme</label>
	  <td><input type="radio" name="radio" id="radio" > <label for="radio">homme</label>
	  
	 </tr>
	 </table>
	  
     </fieldset>
     
	  <table>
	   
	  <tr>
	  <td>Relation familiale</td>
     <td><select name="relation">
        <option value="p">Pére</option>
        <option value="m">Mère</option>
        <option value="o">Oncle</option>
        
    </select>
    </td>
    </tr>
    <tr>
    
	  <td>Adress :</td>
	  <td><textarea name="adress" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;"  >ENTER ADRESS</textarea></td>
	  
	</tr>
	<tr>
    
	  <td>Tel mobile:</td> <td><label>+212(0)6</label>
	  <input name="telmobile" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	
	<tr>
    
	  <td>Tel fix:</td> <td><label>+212(0)5</label>
	  <input name="telfix" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Ville :</td> 
	  <td><input name="ville" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Email :</td>
	  <td><input name="email" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	<tr>
    
	  <td>Travail :</td>
	  <td><input name="travail" style="border:solid 1px black; border-radius:5px; text-align:center; box-shadow:0 0 6px;" /></td>
	  
	</tr>
	
     <tr>
	  <td><input type="submit" value="Submit !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	  <td><input type="reset" value="Reset !" style="cursor:pointer; padding:5px 20px; background-color:lightsteelblue; border:dotted 2px grey; border-radius:5px;" /></td>
	 </tr>
	</table>
	
		
</body>
</html>