<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1>Eni-Enchères</h1>
	<h3>Se connecter</h3>
	<p>${sessionScope.pseudo}</p>
	<form action="<%=request.getContextPath()%>/VerificationUser" method="post">
		<input type="text" placeholder ="Entrer votre pseudonyme ici" name="pseudo" required>
		
		<input type="password" placeholder ="Entrer votre mot de passe ici" name="mdp" required>
		
		<input  type="submit" submit="Valider" id="submit" >
		
	</form>	
	<%
String message = null;
if (request.getAttribute("message")!= null){
	message = (String)request.getAttribute("message");%>
	<p style="color: red;"><%=message %></p>
<%}; %>	
		
	<form action="<%=request.getContextPath()%>/Inscription" method="post">	
		<button  type="submit" submit="Valider" id="submit">S'inscrire</button>
	</form>	
</body>
</html>