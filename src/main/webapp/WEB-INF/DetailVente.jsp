<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Articles_vendus" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Détails Vente</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
		<%@include file="fragments/header.jspf" %>
		<br>
		<h3>Détail vente</h3>
<br>
			<%
			 List<Articles_vendus> list = (List<Articles_vendus>)request.getAttribute("listeEnchere");
				   		for (Articles_vendus art : list){ 
				    	if (list !=null) {
				    	String noArticleStr = (String)request.getAttribute("noArticleStr");
				    	int noArticle = Integer.parseInt(noArticleStr);   		
				    	if (noArticle==art.getNoArticle()){
			%>    			

				<p>Nom de l'article : <%=art.getNomArticle()%></p>
				<p>Description : <%=art.getDescription()%></p>
				<p>Catégorie : <%=art.getCategorie().getLibelle()%> </p>
				<%	Enchere meilleurOffre = null;
				if (request.getAttribute("meilleurOffre") != null) {
					meilleurOffre = (Enchere)request.getAttribute("meilleurOffre");
					}
					if (meilleurOffre != null) {
					int meilleurPrix = meilleurOffre.getMontantEnchere();%>
					<p>Meilleure offre : <%=meilleurPrix %></p>
				<% 	} %>
				
				<p>Mise à prix : <%=art.getPrixDepart()%></p>
				<p>Debut de l'enchère : <%=art.getDateDebutEncheres()%></p>
				<p>Fin de l'enchère : <%=art.getDateFinEncheres()%></p>
				<p>Retrait :</p>
				<p>Vendeur : <%=art.getUtilisateur().getPseudo()%></p>	
					<form action="<%=request.getContextPath()%>/NouvelleEnchere" method="post">
					<%
					// regarde le mini prix
								int prixdepart = art.getPrixDepart();
								int min = prixdepart;
								int meilleurPrix = 100;
									if (meilleurPrix > prixdepart) {
										min = meilleurPrix;	
									}
									// rendre les enchere possible si dans les date d'encheres
									LocalDate datedebut = art.getDateDebutEncheres();
									LocalDate datefin = art.getDateFinEncheres();
									Boolean flag = false;
									if(LocalDate.now().isBefore(datefin) && LocalDate.now().isAfter(datedebut)){
										flag = true;
					%>
							<p>Offre : 	<input type="number" id="offre" name="offre" min="<%=min%>" ></p>
						<% } else {
						flag = false;%>
							<p>Offre : 	<input type="number" id="offre" name="offre" min="<%=min%>" disabled="disabled"></p>
						<%}
							%>										
							<input id="prodId" name="noArticle" type="hidden" value="<%=art.getNoArticle() %>">
							<input id="prodId" name="id" type="hidden" value="${sessionScope.id}">
							<input type="submit" id="encherir" name ="encherir" value="Enchérir">
							</form>
							
							<%String pseudo = (String)request.getSession(false).getAttribute("pseudo");
							if (art.getUtilisateur().getPseudo().equals(pseudo) && flag==false ) {%>
								<input type="submit" id="Annuler" name ="Annuler" value="Annuler vente">
							<%}
							}
							}
				   		}
							%>
	</body>
</html>