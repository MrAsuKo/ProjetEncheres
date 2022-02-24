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

		<h3>Mon profil</h3>
		<br>

		<form action="" method="post" onsubmit="">>
			<p>Pseudo : <input type="text" id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]+" value="${sessionScope.pseudo}" required></p>
			<p>Nom : <input type="text" id="nom" name="nom" value="${sessionScope.nom}" required></p>
			<p>Prenom : <input type="text" id="prenom" name="prenom" value="${sessionScope.prenom}" required></p>
			<p>Email : <input type="email" id="email" name="email" value="${sessionScope.email}"></p>
			<p>Téléphone : <input type="tel" id="telephone" name="telephone" pattern="[0-9]{10}" value="${sessionScope.telephone}" required></p>
			<p>Rue : <input type="text" id="rue" name="rue" value="${sessionScope.rue}" required></p>
			<p>Code postal : <input type="text" id="cp" name="cp" pattern="[0-9]{5}" value="${sessionScope.cp}" required></p>
			<p>Ville : <input type="text" id="ville" name="ville" value="${sessionScope.ville}" required></p>
			<p>Mot de passe actuel : <input type="password" id="mdp" name="mdp"></p>
			<p>Nouveau mot de passe : <input type="password" id="nouveau_mdp" name="nouveau_mdp" required></p>
			<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf" required></p>
			<input type="submit" id="enregistrer" name ="enregistrer" value="Enregistrer" >
		</form>
		<form action="<%=request.getContextPath()%>/Home" method="post">
			<input type="submit" id="supprimer" name ="supprimer" value="Supprimer mon compte">
		</form>
	</body>
</html> 