<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Articles_vendus" %>
<%@ page import="fr.eni.encheres.bo.Categorie" %>
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
		<br>
		<h3> Liste des enchères</h3>
<br>
	<form action="<%=request.getContextPath()%>/FiltreRechercheNonConnect" method="post">

	<div class="row justify-content-start">
	<div class="col-2">
	<input class="form-control me-2" type="text" id="contient" name ="contient" placeholder="Le nom de l'article contient">
	</div>
	<div class="col-2">
	<select class="form-select" name="categorie" id="categorie">
    <option  value="0">Choisir une categorie</option>
    <% List<Categorie> list2 = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list2){ 
    if(list2 != null) {%>
    	<option  value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%}
    }
    %>
    </select>
    </div>
    <div class="col-2">
		<input class="btn btn-outline-warning" type="submit" id="recherche" name ="recherche" value="Rechercher">
		</div>
		</div>
	</form>
	<br>
	<br>

	<div class="row row-cols-xxl-6 row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2">	
    <%
	    List<Articles_vendus> list = (List<Articles_vendus>)request.getAttribute("listeEnchere");
	        for (Articles_vendus art : list){ 
	        	if (list !=null) {
	        	int noArticle = art.getNoArticle();
	    %>
    	<div class="col">
    		<div class="p-4 card border-warning bg-dark mb-3" style="max-width: 18rem;">
  				<div class="card-header">Vendeur : <%=art.getUtilisateur().getPseudo()%></div>
  					<div class="card-body">
    					<h5 class="card-title"><%=art.getNomArticle()%></h5>
						    <p class="card-text">Prix : <%=art.getPrixDepart()%></p>
						    <p class="card-text">Fin de l'enchère : <%=art.getDateFinEncheres()%></p>
  					</div>
				</div>
			</div>
	    <%}
		}
	    %>
	</div>
	   
	</body>
</html>