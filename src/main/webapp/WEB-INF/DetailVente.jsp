<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.gestion_vente.bo.Vente" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vente</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<h1>ENI - Enchères</h1>
		<h3>Détail vente</h3>

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
					<p>Meilleure offre : <%=message %></p>
				<% 	} %>
				
				<p>Mise à prix : <%=art.getPrixdepart()%></p>
				<p>Fin de l'enchère : <%=art.getFinenchere()%></p>
				<p>Retrait :</p>
				<p>Vendeur : <%=art.getPseudo()%></p>	
					<form action="<%=request.getContextPath()%>/NouvelleEnchere" method="post">
					<% 
					int prixdepart = Integer.parseInt(art.getPrixdepart());
					int min = prixdepart;
					int meilleurOffre = Integer.parseInt(message);
						if (meilleurOffre > prixdepart) {
							min = meilleurOffre;	
						}
						else {
						min = prixdepart;
						}
						%>	
				<p>Offre : 	<input type="number" id="offre" name="offre" min="<%=min%>"></p>
							<input id="prodId" name="noArticle" type="hidden" value="<%=art.getIdEnchere() %>">
							<input id="prodId" name="id" type="hidden" value="${sessionScope.id}">
							<input type="submit" id="encherir" name ="encherir" value="Enchérir">
							</form>
				<%} %>
	
		
			<%}
		    }
		    %>
	</body>
</html>