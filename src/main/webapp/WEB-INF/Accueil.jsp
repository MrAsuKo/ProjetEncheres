<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link href="./css/style.css" rel="stylesheet"> 
</head>
<body>

<div>
<p>ENI - Enchere</p>
<a href="./Inscription.jsp">S'incrire</a>
<a href="./SeConnecter.jsp">Se connecter</a>
</div>

<h1> Liste des enchères</h1>

<form action="" method="get">
<input type="text" id="nom" name ="nom" value="le nom de l'article contient">
<select name="categories" id="categories">
<option value="Catego">Toutes</option>
<option value="Catego">--Please choose an option--</option>
</select>
<input type="submit" id="recherche" name ="recherche" value="recherche">
</form>

<p>Liste enchere a prevoir</p>

</body>
</html>