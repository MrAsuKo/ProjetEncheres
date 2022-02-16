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
<form action="" method="post">
<p>Pseudo : <input type="text" id="pseudo" name="pseudo" placeholder="${sessionScope.pseudo}"></p>
<p>Nom : <input type="text" id="nom" name="nom" placeholder="${sessionScope.nom}"></p>
<p>Prenom : <input type="text" id="prenom" name="prenom" placeholder="${sessionScope.prenom}"></p>
<p>Email : <input type="text" id="email" name="email" placeholder="${sessionScope.email}"></p>
<p>Téléphone : <input type="text" id="telephone" name="telephone" placeholder="${sessionScope.telephone}"></p>
<p>Rue : <input type="text" id="rue" name="rue" placeholder="${sessionScope.rue}"></p>
<p>Code postal : <input type="text" id="cp" name="cp" placeholder="${sessionScope.cp}"></p>
<p>Ville : <input type="text" id="ville" name="ville" placeholder="${sessionScope.ville}"></p>
<p>Mot de passe actuel : <input type="text" id="mdp" name="mdp"></p>
<p>Nouveau mot de passe : <input type="password" id="mdp" name="mdp"></p>
<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf"></p>
<button type="submit">Enregistrer</button>
<button type="submit">Supprimer mon compte</button>
</form>
</body>
</html>