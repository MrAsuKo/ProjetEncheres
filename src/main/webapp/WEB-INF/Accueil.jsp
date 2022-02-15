<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="./css/style.css" rel="stylesheet"> 
</head>
<body>

<div>
<%@include file="fragments/header.jspf" %>
<a href="./SeConnecter.jsp">S'inscrire - Se connecter</a>
</div>

<h1> Liste des enchères</h1>

<form action="" method="post">
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