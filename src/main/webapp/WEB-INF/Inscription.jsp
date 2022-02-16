<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@include file="fragments/header.jspf" %>
<h3>Mon profil</h3>
<form action="<%=request.getContextPath()%>/CreationUser" method="post">
<input type="text" name="pseudo" placeholder="Pseudo" required>
<input type="text" name="nom" placeholder="Nom" required>
<input type="text" name="prenom" placeholder="Prénom" required>
<input type="text" name="email" placeholder="Email" required>
<input type="text" name="telephone" placeholder="Téléphone" required>
<input type="text" name="rue" placeholder="Rue" required>
<input type="text" name="cp" placeholder="Code postal" required>
<input type="text" name="ville" placeholder="Ville" required>
<input type="password" name="mdp" placeholder="Mot de passe" required>
<input type="password" name="mdp_conf" placeholder="Confirmation" required>
<button type="submit">Créer</button>
<button type="submit">Annuler</button>
</form>
	<%
	String message = null;
	if (request.getAttribute("message") != null) {
	message = (String)request.getAttribute("message");
	}
	%>
	<% if (request.getAttribute("message") != null) {%>
	<p style="color: red"><%=message %></p>
	<%} %>
</body>
</html>