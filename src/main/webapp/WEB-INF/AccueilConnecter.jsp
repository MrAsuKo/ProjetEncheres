<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil Connecté</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="./css/style.css" rel="stylesheet">  
</head>
<body>

<div>
<%@include file="fragments/header.jspf" %>
<h4>Bienvenue ${sessionScope.pseudo}</h4>
<a href="">Encheres</a>
<a href="<%=request.getContextPath()%>/NouvelleVente">Vendre un article</a>
<a href="<%=request.getContextPath()%>/AfficherProfil">Mon profil</a>
<a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion</a>
</div>
<form action="<%=request.getContextPath()%>/NouvelleVente" method="post">
<input type="submit" id="nouvelleenchere" name ="nouvelleenchere" value="nouvelle enchere">
</form>
<h3> Liste des enchères</h3>

<form action="" method="post">
<input type="text" id="nom" name ="nom" value="le nom de l'article contient">
<select name="categories" id="categories">
<option value="Catego">Toutes</option>
<option value="Catego">--Please choose an option--</option>
</select>
<input type="submit" id="recherche" name ="recherche" value="recherche">
</form>

<div>
  <input type="checkbox" id="type" name="type">
  <label style="border-radius: 50%" for="achats">Achats</label>
		<input type="checkbox" id="typeachat" name="typeachat">
		<label style="border-radius: 50%" for="enchères ouvertes">enchères ouvertes</label>
		<label style="border-radius: 50%" for="mes enchères">mes enchères</label>
		<label style="border-radius: 50%" for="mes emchères remportées">mes emchères remportées</label>
  <label style="border-radius: 50%" for="ventes">Mes ventes</label>
  		<input type="checkbox" id="typevente" name="typevente">
  		<label style="border-radius: 50%" for="mes ventes en cours">mes ventes en cours</label>
  		<label style="border-radius: 50%" for="ventes non debutées">ventes non debutées</label>
  		<label style="border-radius: 50%" for="ventes terminées">ventes terminées</label>
</div>

<p>Liste enchere a prevoir</p>

</body>
</html>