<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mon Profil</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
		<%@include file="fragments/header.jspf" %>
		<br>
		<h3>Mon profil</h3>
		<br>
		<div class="p-3 card border-warning bg-dark mb-4" style="max-width: 20rem;">
		<p>Pseudo : ${sessionScope.pseudo}</p>
		<p>Nom : ${sessionScope.nom}</p>
		<p>Prénom : ${sessionScope.prenom}</p>
		<p>Email : ${sessionScope.email}</p>
		<p>Téléphone : ${sessionScope.telephone}</p>
		<p>Rue : ${sessionScope.rue}</p>
		<p>Code postal : ${sessionScope.cp}</p>
		<p>Ville : ${sessionScope.ville}</p>
		<p>Crédit : ${sessionScope.credit}</p>
		</div>
		<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
			<input class="btn btn-outline-warning" type="submit" id="modifier" name ="modifier" value="Modifier">
		</form>
	</body>
</html>