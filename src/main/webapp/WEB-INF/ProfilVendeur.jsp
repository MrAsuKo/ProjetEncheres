<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="fr.eni.encheres.bo.Articles_vendus" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
<title>Profil Vendeur</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
<%@include file="fragments/header.jspf" %>
<br>
		<h3>Profil vendeur</h3>
		<br>
		<div class="p-3 card border-warning bg-dark mb-4" style="max-width: 20rem;">
		<p class="fs-5">Pseudo : ${user.pseudo}</p>
		<p class="fs-5">Nom : ${user.nom}</p>
		<p class="fs-5">Prénom : ${user.prenom}</p>
		<p class="fs-5">Email : ${user.email}</p>
		<p class="fs-5">Téléphone : ${user.telephone}</p>
		</div>
	</body>
</html>