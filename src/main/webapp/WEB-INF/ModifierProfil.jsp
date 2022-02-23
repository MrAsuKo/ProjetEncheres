<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	<body>
		<%@include file="fragments/header.jspf" %>
		<br>
		<h3>Mon profil</h3>
		<br>
		<form action="" method="post">
			<p>Pseudo : <input type="text" id="pseudo" name="pseudo" value="${sessionScope.pseudo}" required></p>
			<p>Nom : <input type="text" id="nom" name="nom" placeholder="${sessionScope.nom}"></p>
			<p>Prenom : <input type="text" id="prenom" name="prenom" placeholder="${sessionScope.prenom}"></p>
			<p>Email : <input type="text" id="email" name="email" placeholder="${sessionScope.email}"></p>
			<p>Téléphone : <input type="text" id="telephone" name="telephone" placeholder="${sessionScope.telephone}"></p>
			<p>Rue : <input type="text" id="rue" name="rue" placeholder="${sessionScope.rue}"></p>
			<p>Code postal : <input type="text" id="cp" name="cp" placeholder="${sessionScope.cp}"></p>
			<p>Ville : <input type="text" id="ville" name="ville" placeholder="${sessionScope.ville}"></p>
			<p>Mot de passe actuel : <input type="password" id="mdp" name="mdp"></p>
			<p>Nouveau mot de passe : <input type="password" id="mdp" name="mdp"></p>
			<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf"></p>
			<input type="submit" id="enregistrer" name ="enregistrer" value="Enregistrer">
		</form>
			<form action="<%=request.getContextPath()%>/Home" method="post">
			<input type="submit" id="supprimer" name ="supprimer" value="Supprimer mon compte">
		</form>
	</body>
</html>