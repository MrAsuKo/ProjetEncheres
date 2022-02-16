<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>
</head>
<body>
	<h1>Eni-Ench�res</h1>
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