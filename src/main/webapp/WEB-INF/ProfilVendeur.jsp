<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.eni.gestion_vente.bo.Vente" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>

		
		<p>Pseudo : ${user.pseudo}</p>
		<p>Nom : ${user.nom}</p>
		<p>Pr�nom : ${user.prenom}</p>
		<p>Email : ${user.email}</p>
		<p>T�l�phone : ${user.telephone}</p>
		<p>Rue : ${user.rue}</p>
		<p>Code postal : ${user.cp}</p>
		<p>Ville : ${user.ville}</p>
		<p>Cr�dit : ${user.credit}</p>

	</body>
</html>