<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Spring MVC Tutorial Series by Crunchify.com</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h2>
			GESMA INSCRIPTION<br> <br>
		</h2>
		<h3>
			<a href="welcome.html">Click here to add new student </a>(to
			check Spring MVC Controller... @RequestMapping("/welcome"))
		</h3>
		
	</div>
	<div id="listesetudiants">
	<table>
	<th>num1</th><th>num2</th><th>num3</th><th>num4</th>
	<c:forEach items="${etudiants}" var="e">
	 <tr>
	 <td>${e.num_inscription}</td>
	 <td>${e.num_national}</td>
	 <td>${e.num_national_massar}</td>
	 <td>${e.num_carte_national}</td>
	 </tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>