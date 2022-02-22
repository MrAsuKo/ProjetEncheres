<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.gestion_vente.bo.Vente" %>
<%@ page import="fr.eni.gestion_vente.bo.Categorie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
		<%@include file="fragments/header.jspf" %>
		<a href="<%=request.getContextPath()%>/SeConnecter">S'inscrire - Se connecter</a>
		<h3> Liste des enchères</h3>

	<form action="<%=request.getContextPath()%>/FiltreRecherche" method="post">
	<input type="text" id="contient" name ="contient" placeholder="Rechercher sur Bidhub">
	<p>Catégorie : <select name="categorie" id="categorie">
    <option  value="0">---- Choisir une categorie ----</option>
    <% List<Categorie> list2 = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list2){ %>
    	<option  value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%}
    %>
		<input type="submit" id="recherche" name ="recherche" value="Rechercher">
	</form>

	<div class="row row-cols-xxl-6 row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2">	
    <% List<Vente> list = (List<Vente>)request.getAttribute("listeEnchere");
    for (Vente art : list){ 
    	if (list !=null) {
    	int noArticle = art.getIdEnchere();%>
    	<div class="col">
    		<div class="p-4 card border-warning bg-dark mb-3" style="max-width: 18rem;">
  				<div class="card-header">Vendeur : <%=art.getPseudo()%></div>
  					<div class="card-body">
    					<h5 class="card-title"><%=art.getArticle()%></h5>
						    <p class="card-text">Prix : <%=art.getPrixdepart()%></p>
						    <p class="card-text">Fin de l'enchère : <%=art.getFinenchere()%></p>
  					</div>
				</div>
			</div>
	    <%}
		}
	    %>
	</div>
	   
	</body>
</html>