<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Articles_vendus" %>
<%@ page import="fr.eni.encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil Connecté</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
		<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
	<%@include file="fragments/header.jspf" %>
	<br>
	<h3> Liste des enchères</h3>
	<br>
	<form action="<%=request.getContextPath()%>/FiltreRecherche" method="post">
	<div class="row justify-content-start">
	<div class="col-2">
	<input class="form-control me-2" type="text" id="contient" name ="contient" placeholder="Le nom de l'article contient">
	</div>
	<div class="col-2">
	<select class="form-select" name="categorie" id="categorie">
    <option  value="0">Choisir une categorie</option>
    <% List<Categorie> list2 = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list2){ %>
    	<option  value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%
    }
    %>
    </select>
    </div>
    </div>
    <br>
    <!-- Filtre checkbox -->
    <div class="row justify-content-start">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<div class="col-2 form-check form-switch">
				<input class="form-check-input" role="switch" type="radio" id="achat" name="achat">
				<label for="achats">Achats</label>
					<ul style="list-style: none;">
						<li><input class="form-check-input" type="checkbox" id="encheresouvertes" name="encheresouvertes"><label class="form-check-label" for="encheresouvertes">Enchères ouvertes</label></li>
						<li><input class="form-check-input" type="checkbox" id="mesencheres" name="mesencheres"><label class="form-check-label" for="mesencheres">Mes enchères</label></li>
						<li><input class="form-check-input" type="checkbox" id="mesemcheresremportees" name="mesemcheresremportees"><label class="form-check-label" for="mesemcheresremportees">Mes enchères remportées</label></li>
					</ul>
					</div>
					<div class="col-2 form-check form-switch">
				<input class="form-check-input" role="switch" type="radio" id="vente" name="achat">
				<label for="achats">Mes ventes</label>
					<ul style="list-style: none;">
						<li><input class="form-check-input" type="checkbox" id="mesventesencours" name="mesventesencours"><label class="form-check-label" for="mesventesencours">Mes ventes en cours</label></li>
						<li><input class="form-check-input" type="checkbox" id="ventesnondebutees" name="ventesnondebutees"><label class="form-check-label" for="ventesnondebutees">Ventes non debutées</label></li>
						<li><input class="form-check-input" type="checkbox" id="ventesterminees" name="ventesterminees"><label class="form-check-label" for="ventesterminees">Ventes terminées</label></li>
					</ul>
					</div>
		<div class="col-2">
		<input class="btn btn-outline-warning" type="submit" id="recherche" name ="recherche" value="Rechercher">
		</div>
		</div>
	</form>
	<br>

	<div class="row row-cols-xxl-6 row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2">	
    <%
	    List<Articles_vendus> list = (List<Articles_vendus>)request.getAttribute("listeEnchere");
	        for (Articles_vendus art : list){ 
	        	if (list !=null) {
	        	int noArticle = art.getNo_article();
	    %>
    	<div class="col">
    		<div class="p-4 card border-warning bg-dark mb-3" style="max-width: 18rem;">
  				<div class="card-header">Vendeur : <a href="./Show/Vendeur?name=<%=art.getPseudo()%>"><%=art.getPseudo()%></a></div>
  					<div class="card-body">
    					<h5 class="card-title"><a href="<%=request.getContextPath()%>/DetailVente?name=<%=art.getNo_article()%>&datefin=<%=art.getDate_fin_encheres()%>"><%=art.getNom_article()%></a></h5>
						    <p class="card-text">Prix : <%=art.getPrixdepart()%></p>
						    <p class="card-text">Fin de l'enchère : <%=art.getDate_fin_encheres()%></p>
  					</div>
				</div>
			</div>
	    <%}
		}
	    %>
	</div>

	</body>
</html>