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
		<br>
		<h3>Créer mon Profil</h3>
		<br>
		<form action="<%=request.getContextPath()%>/AccueilInscr" method="post">
		<div class="row">
		<div class="col-2">
			<p>Pseudo : <input class="form-control me-2" type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]+" required></p>
			<p>Nom : <input class="form-control me-2" type="text" id="nom" name="nom" required></p>
			<p>Prenom : <input class="form-control me-2" type="text" id="prenom" name="prenom" required></p>
			<p>Email : <input class="form-control me-2" type="email" id="email" name="email" required></p>
			<p>Téléphone : <input class="form-control me-2" type="tel" id="telephone" name="telephone" pattern="[0-9]{10}" required></p>
			</div>
			<div class="col-2">
			<p>Rue : <input class="form-control me-2" type="text" id="rue" name="rue" required></p>
			<p>Code postal : <input class="form-control me-2" type="text" id="cp" name="cp" pattern="[0-9]{5}" required></p>
			<p>Ville : <input class="form-control me-2" type="text" id="ville" name="ville" required></p>
			<p>Mot de passe : <input class="form-control me-2" type="password" id="mdp" name="mdp" required></p>
			<p>Confirmer mot de passe : <input class="form-control me-2" type="password" id="mdp_conf" name="mdp_conf" required></p>
			</div>
			</div>
			<%	String message = null;
				if (request.getAttribute("message") != null) {
					message = (String)request.getAttribute("message"); %>
					<p style="color: red;"><%=message %></p>
			<% 	} %>
			<input class="btn btn-outline-warning position-absolute" type="submit" id="créer" name ="créer" value="Créer">
		</form>
		<form style="padding-left: 80px;" action="<%=request.getContextPath()%>/SeConnecter" method="post">
			<input class="btn btn-outline-warning" type="submit" id="annuler" name ="annuler" value="Annuler">
		</form>
	</body>
</html> 