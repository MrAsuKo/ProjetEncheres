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
<p>Pseudo : ${sessionScope.pseudo}</p>
<input type="text" id="pseudo" name="pseudo">
<p>Nom : ${sessionScope.nom}</p>
<input type="text" id="nom" name="nom">
<p>Prenom : ${sessionScope.prenom}</p>
<input type="text" id="prenom" name="prenom">
<p>Email : ${sessionScope.email}</p>
<input type="text" id="email" name="email">
<p>Téléphone : ${sessionScope.telephone}</p>
<input type="text" id="telephone" name="telephone">
<p>Rue : ${sessionScope.rue}</p>
<input type="text" id="rue" name="rue">
<p>Code postal : ${sessionScope.cp}</p>
<input type="text" id="cp" name="cp">
<p>Ville : ${sessionScope.ville}</p>
<input type="text" id="ville" name="ville">
<p>Mot de passe actuel :</p>
<input type="text" id="mdp" name="mdp">
<p>Nouveau mot de passe :</p>
<input type="password" id="mdp" name="mdp">
<p>Confirmer mot de passe :</p>
<input type="password" id="mdp_conf" name="mdp_conf">
<button type="submit">Enregistrer</button>
<button type="submit">Supprimer mon compte</button>
</form>
</body>
</html>