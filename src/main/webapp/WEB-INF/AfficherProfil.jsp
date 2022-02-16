<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<body>
<h1>ENI - Enchères</h1>
<h3>Mon profil</h3>
<p>Pseudo : ${sessionScope.pseudo}</p>
<p>Nom : ${sessionScope.nom}</p>
<p>Prénom : ${sessionScope.prenom}</p>
<p>Email : ${sessionScope.email}</p>
<p>Téléphone : ${sessionScope.telephone}</p>
<p>Rue : ${sessionScope.rue}</p>
<p>Code postal : ${sessionScope.cp}</p>
<p>Ville : ${sessionScope.ville}</p>
<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
<button type="submit">Modifier</button>
</form>
</body>
</html>