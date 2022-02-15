<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<h1>ENI - Enchères</h1>
<h3>Mon profil</h3>
<form action="<%=request.getContextPath()%>/CreationUser" method="post">
<input type="text" name="pseudo" placeholder="Pseudo">
<input type="text" name="nom" placeholder="Nom">
<input type="text" name="prenom" placeholder="Prénom">
<input type="text" name="email" placeholder="Email">
<input type="text" name="telephone" placeholder="Téléphone">
<input type="text" name="rue" placeholder="Rue">
<input type="text" name="cp" placeholder="Code postal">
<input type="text" name="ville" placeholder="Ville">
<input type="text" name="mdp" placeholder="Mot de passe">
<input type="text" name="mdp_conf" placeholder="Confirmation">
<button type="submit">Créer</button>
<button type="submit">Annuler</button>
</form>
	<%
	 String message = null;
	if (application.getAttribute("message") != null);
	message = (String)application.getAttribute("message");
	%>
	<p><%=message %></p>
</body>
</html>