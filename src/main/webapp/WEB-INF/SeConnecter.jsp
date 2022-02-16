<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%@include file="fragments/header.jspf" %>
	<h3>Se connecter</h3>
	<p>${sessionScope.pseudo}</p>
	<form action="<%=request.getContextPath()%>/VerificationUser" method="post">
		<p>Pseudo :</p>
		<input type="text" placeholder ="Entrer votre pseudonyme ici" name="pseudo" required>
		<p>Mot de passe :</p>
		<input type="password" placeholder ="Entrer votre mot de passe ici" name="mdp" required>
		
		<input  type="submit" submit="Valider" id="submit" >
		
	</form>	
	
	<form action="<%=request.getContextPath()%>/Inscription" method="post">	
		<button  type="submit" submit="Valider" id="submit">S'inscrire</button>
	</form>	
</body>
</html>