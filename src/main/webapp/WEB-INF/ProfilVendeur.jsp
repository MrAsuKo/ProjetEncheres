<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="fr.eni.gestion_vente.bo.Vente" %>
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
		<h3>Profil Vendeur</h3>
		<p>Pseudo : ${user.pseudo}</p>
		<p>Nom : ${user.nom}</p>
		<p>Prénom : ${user.prenom}</p>
		<p>Email : ${user.email}</p>
		<p>Téléphone : ${user.telephone}</p>
		<p>Rue : ${user.rue}</p>
		<p>Code postal : ${user.cp}</p>
		<p>Ville : ${user.ville}</p>
		<p>Crédit : ${user.credit}</p>

	</body>
</html>