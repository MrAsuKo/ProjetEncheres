<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Se connecter</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
		<%@include file="fragments/header.jspf" %>
			<%
			String value = "";
			if (request.getAttribute("pseudo") != null) {
				value = (String)request.getAttribute("pseudo");
			}
			%>
		<h3>Se connecter</h3>
		<p>${sessionScope.pseudo}</p>
		<form action="<%=request.getContextPath()%>/AccueilConnect" method="post">
			<p>Pseudo : <input type="text" id="pseudo" name="pseudo" placeholder="votre pseudo..." value="<%=value%>" required></p>
			<p>Mot de passe : <input type="password" id="mdp" name="mdp" required></p>
			<p><input type="checkbox" id="memoriser" name="memoriser">
				<label for="memoriser">Se souvenir</label></p>
			<%	String message = null;
				if (request.getAttribute("message") != null) {
					message = (String)request.getAttribute("message"); %>
					<p style="color: red;"><%=message %></p>
			<% 	}; %>
			<input type="submit" id="valider" name ="valider" value="Valider">
		</form>	
		<form action="<%=request.getContextPath()%>/Inscription" method="post">	
			<input type="submit" id="inscription" name ="inscription" value="S'inscrire">
		</form>	
	</body>
</html>