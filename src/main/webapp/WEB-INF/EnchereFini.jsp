<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.gestion_vente.bo.Vente" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vente Fini</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
</head>
<body>
<%@include file="fragments/header.jspf" %>

				<%	
				String pseudo = null;
				if (request.getAttribute("pseudo") != null) {
				pseudo = (String)request.getAttribute("pseudo");
				}
				int id = 0;
				int idSession = (int)request.getSession(false).getAttribute("id");
				if (request.getAttribute("id") != null) {
				id = (int)request.getAttribute("id");
				}
				if (id == idSession) {%>
					<h2 style="color:green">YOU WIN !</h2>
					<h3>VOUS AVEZ REMPORTÉ L'ENCHÈRE</h3>
				<%} else { %>
					<h2 style="color:red">YOU LOSE !</h2>
					<h3><%=pseudo %> A REMPORTÉ L'ENCHÈRE</h3>
				<%} %>





			<% List<Vente> list = (List<Vente>)request.getAttribute("listeEnchere");
	   		for (Vente art : list){ 
	    	if (list !=null) {
	    	String noArticleStr = (String)request.getAttribute("noArticleStr");
	    	int noArticle = Integer.parseInt(noArticleStr);   		
	    	if (noArticle==art.getIdEnchere()) {%>    			
				<p>Nom de l'article : <%=art.getArticle()%></p>
				<p>Description : <%=art.getDescription()%></p>
				<p>Catégorie : <%=art.getLibellecatego()%> </p>
				<%	String message = null;
				if (request.getAttribute("meilleurOffre") != null) {
					message = request.getAttribute("meilleurOffre").toString(); %>
					<p>Meilleure offre : <%=message %> par <%=pseudo %></p>
				<% 	} %>
				
				<p>Mise à prix : <%=art.getPrixdepart()%></p>
				<p>Debut de l'enchère : <%=art.getDebutenchere()%></p>
				<p>Fin de l'enchère : <%=art.getFinenchere()%></p>
				<p>Retrait :</p>
				<p>Vendeur : <%=art.getPseudo()%></p>
				<p> Tel : <%=art.getTelephone()%></p>
					<form action="<%=request.getContextPath()%>/BackAccueil" method="post">
							<input type="submit" id="back" name ="back" value="Retour">
							<input id="prodId" name="noArticle" type="hidden" value="<%=art.getIdEnchere() %>">
							<input id="prodId" name="id" type="hidden" value="${sessionScope.id}">
					</form>
							
				<%} %>
	
		
			<%}
		    }
		    %>
</body>
</html>