<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
		<%@include file="fragments/header.jspf" %>
		<h3>Créer mon Profil</h3>
		<form action="<%=request.getContextPath()%>/AccueilInscr" method="post">
			<p>Pseudo : <input type="text" id="pseudo" name="pseudo" required pattern="[a-zA-Z0-9]+" required></p>
			<p>Nom : <input type="text" id="nom" name="nom" required></p>
			<p>Prenom : <input type="text" id="prenom" name="prenom" required></p>
			<p>Email : <input type="text" id="email" name="email" required></p>
			<p>Téléphone : <input type="text" id="telephone" name="telephone" required></p>
			<p>Rue : <input type="text" id="rue" name="rue" required></p>
			<p>Code postal : <input type="text" id="cp" name="cp" required></p>
			<p>Ville : <input type="text" id="ville" name="ville" required></p>
			<p>Mot de passe : <input type="password" id="mdp" name="mdp" required></p>
			<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf" required></p>
			<%	String message = null;
				if (request.getAttribute("message") != null) {
					message = (String)request.getAttribute("message"); %>
					<p style="color: red;"><%=message %></p>
			<% 	}; %>
			<input type="submit" id="créer" name ="créer" value="Créer">
		</form>
		<form action="<%=request.getContextPath()%>/SeConnecter" method="post">
			<input type="submit" id="annuler" name ="annuler" value="Annuler">
		</form>
	</body>
</html>