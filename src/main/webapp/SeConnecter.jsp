<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>
</head>
<body>

	<h1>Se connecter</h1>
	
	<form action="./AccueilServlet.java" method="post">
		<input type="text" placeholder ="Entrer votre pseudonyme ici" name="pseudo" required>
		
		<input type="password" placeholder ="Entrer votre mot de passe ici" name="mdp" required>
		
		<input  type="submit" submit="Valider" id="submit" >
		
	</form>	
		
	<form action="./Inscription.jsp">	
		<button  type="submit" submit="Valider" id="submit">S'inscrire</button>
	</form>	
	
	
	
	
	
	

</body>
</html>