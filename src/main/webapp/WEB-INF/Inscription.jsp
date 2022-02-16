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
<p>Pseudo : <input type="text" id="pseudo" name="pseudo" required></p>
<p>Nom : <input type="text" id="nom" name="nom" required></p>
<p>Prenom : <input type="text" id="prenom" name="prenom" required></p>
<p>Email : <input type="text" id="email" name="email" required></p>
<p>Téléphone : <input type="text" id="telephone" name="telephone" required></p>
<p>Rue : <input type="text" id="rue" name="rue" required></p>
<p>Code postal : <input type="text" id="cp" name="cp" required></p>
<p>Ville : <input type="text" id="ville" name="ville" required></p>
<p>Mot de passe : <input type="password" id="mdp" name="mdp" required></p>
<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf" required></p>
<button type="submit">Créer</button>
</form>
<form action="<%=request.getContextPath()%>/SeConnecter" method="post">
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