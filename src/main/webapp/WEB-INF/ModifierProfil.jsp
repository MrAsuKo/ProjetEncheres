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
<p>Pseudo : ${sessionScope.pseudo} <input type="text" id="pseudo" name="pseudo"></p>
<p>Nom : ${sessionScope.nom} <input type="text" id="nom" name="nom"></p>
<p>Prenom : ${sessionScope.prenom} <input type="text" id="prenom" name="prenom"></p>
<p>Email : ${sessionScope.email} <input type="text" id="email" name="email"></p>
<p>Téléphone : ${sessionScope.telephone} <input type="text" id="telephone" name="telephone"></p>
<p>Rue : ${sessionScope.rue} <input type="text" id="rue" name="rue"></p>
<p>Code postal : ${sessionScope.cp} <input type="text" id="cp" name="cp"></p>
<p>Ville : ${sessionScope.ville} <input type="text" id="ville" name="ville"></p>
<p>Mot de passe actuel : <input type="text" id="mdp" name="mdp"></p>
<p>Nouveau mot de passe : <input type="password" id="mdp" name="mdp"></p>
<p>Confirmer mot de passe : <input type="password" id="mdp_conf" name="mdp_conf"></p>
<button type="submit">Enregistrer</button>
<button type="submit">Supprimer mon compte</button>
</form>
</body>
</html>