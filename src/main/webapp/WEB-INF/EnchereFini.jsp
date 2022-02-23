<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Articles_vendus"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vente Fini</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
</head>
<body>
	<%@include file="fragments/header.jspf"%>
	<br>

	<%
			Enchere meilleureOffre = null;
			if(request.getAttribute("meilleurOffre") != null) {
				meilleureOffre = (Enchere)request.getAttribute("meilleurOffre");
			}
			int id = -1;
			if(meilleureOffre != null) {
				id = meilleureOffre.getUtilisateur().getId();
			}				
			int idSession = (int)request.getSession(false).getAttribute("id");

			if (id == idSession){
	%>
				<h2 style="color: green">YOU WIN !</h2>
				<h3>VOUS AVEZ REMPORTÉ L'ENCHÈRE</h3>
			<%
			} else {
						if(meilleureOffre != null) {
			%>
						<h2 style="color: red">YOU LOSE !</h2>
						<h3><%=meilleureOffre.getUtilisateur().getPseudo()%> A REMPORTÉ L'ENCHÈRE </h3>
				<%


							} else {
				%>
						<h3>PERSONNE A REMPORTÉ L'ENCHÈRE</h3>
					<%

					}
			}
					%>
					<br>
	<%
	 List<Articles_vendus> list = (List<Articles_vendus>)request.getAttribute("listeEnchere");
		   		for (Articles_vendus art : list){ 
		    	if (list !=null) {
		    	String noArticleStr = (String)request.getAttribute("noArticleStr");
		    	int noArticle = Integer.parseInt(noArticleStr);   		
 		    	if (noArticle==art.getNoArticle()){
	%>
	<p><%=art.getNomArticle()%> - <%=noArticle%></p>
	<p>
		Nom de l'article :
		<%=art.getNomArticle()%></p>
	<p>
		Description :
		<%=art.getDescription()%></p>
	<p>
		Catégorie :
		<%=art.getCategorie().getLibelle()%>
	</p>

	<%if (meilleureOffre != null) { %>
	<p>
		Meilleure offre :
		<%=meilleureOffre.getMontantEnchere() %>
		par
		<%=meilleureOffre.getUtilisateur().getPseudo() %></p>
	<p>
	<%} %>
		Mise à prix :
		<%=art.getPrixDepart()%></p>
	<p>
		Debut de l'enchère :
		<%=art.getDateDebutEncheres()%></p>
	<p>
		Fin de l'enchère :
		<%=art.getDateFinEncheres()%></p>
	<p>Retrait :</p>
	<p>
		Vendeur :
		<%=art.getUtilisateur().getPseudo()%></p>
	<p>
		Tel :
		<%=art.getUtilisateur().getTelephone()%></p>
	<form action="<%=request.getContextPath()%>/BackAccueil" method="post">
		<input type="submit" id="back" name="back" value="Retour"> <input
			id="prodId" name="noArticle" type="hidden"
			value="<%=art.getNoArticle() %>"> <input id="prodId"
			name="id" type="hidden" value="${sessionScope.id}">
	</form>

	<%}
   	}
  	}
	
	%>
</body>
</html>