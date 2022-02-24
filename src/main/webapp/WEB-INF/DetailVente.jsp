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
		<h3>Détails vente</h3>
<br>
<div class="p-3 card border-warning bg-dark mb-4" style="max-width: 20rem;">
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
					int meilleurPrix = meilleurOffre.getMontantEnchere();
					%>
					<p>Meilleure offre : <%=meilleurPrix %></p>
				<% 	} %>
				
				<p>Mise à prix : <%=art.getPrixDepart()%></p>
				<p>Debut de l'enchère : <%=art.getDateDebutEncheres().getDayOfMonth() %>/<%=art.getDateDebutEncheres().getMonthValue() %>/<%=art.getDateDebutEncheres().getYear() %></p>
				<p>Fin de l'enchère : <%=art.getDateFinEncheres().getDayOfMonth() %>/<%=art.getDateFinEncheres().getMonthValue() %>/<%=art.getDateFinEncheres().getYear() %></p>
				<p>Retrait :</p>
				<p>Vendeur : <%=art.getUtilisateur().getPseudo()%></p>	
				</div>	
				<div class="col-2">
					<% if (!art.getUtilisateur().getPseudo().equals(request.getSession(false).getAttribute("pseudo"))){ %>
					<form action="<%=request.getContextPath()%>/NouvelleEnchere" method="post">
					<%
									// regarde le mini prix
									int prixdepart = art.getPrixDepart();
									int min = prixdepart+1;
									int meilleurPrix =0;
									Enchere meilleurOffre2 = null;
									if (request.getAttribute("meilleurOffre") != null) {
										meilleurOffre2 = (Enchere)request.getAttribute("meilleurOffre");
										}
										if (meilleurOffre2 != null) {
										meilleurPrix = meilleurOffre2.getMontantEnchere();
										}
									if (meilleurPrix > prixdepart) {
										min = meilleurPrix+1;								
									}
									// rendre les enchere possible si dans les date d'encheres
									LocalDate datedebut = art.getDateDebutEncheres();
									LocalDate datefin = art.getDateFinEncheres();
									Boolean flag = false;
									if(LocalDate.now().isAfter(datedebut) || LocalDate.now().isEqual(datedebut)){ 
										flag = true	;
					%>
							<p>Offre : 	<input class="form-control me-2" type="number" id="offre" name="offre" min="<%=min%>" value="<%=min%>" ></p>
						<% } else {
						flag = false;%>
							<p>Offre : 	<input class="form-control me-2" type="number" id="offre" name="offre" min="<%=min%>" value="<%=min%>" disabled="disabled"></p>
						<%}
							%>									
							<input id="prodId" name="noArticle" type="hidden" value="<%=art.getNoArticle() %>">
							<input id="prodId" name="id" type="hidden" value="${sessionScope.id}">
							<input class="btn btn-outline-warning" type="submit" id="encherir" name ="encherir" value="Enchérir">
							</form>
							<%} %>
							</div>
							<form action="<%=request.getContextPath()%>/CancelBackAccueil" method="post">
							<input id="prodId" name="noArticle" type="hidden" value="<%=art.getNoArticle() %>">
							<%boolean flag = false;
							LocalDate datedebut = art.getDateDebutEncheres();
							LocalDate datefin = art.getDateFinEncheres();
							if(LocalDate.now().isAfter(datedebut) || LocalDate.now().isEqual(datedebut)){ 
								flag = true	;
							}
							String pseudo = (String)request.getSession(false).getAttribute("pseudo");
							if (art.getUtilisateur().getPseudo().equals(pseudo) && flag==false ) {%>
								<input class="btn btn-outline-warning" type="submit" id="Annuler" name ="Annuler" value="Annuler vente">
							<%} %>
							</form>
							<% }
							}
				   		}
							%>
	</body>
</html> 