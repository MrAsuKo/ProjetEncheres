<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.gestion_vente.bo.Vente" %>
<%@ page import="fr.eni.gestion_vente.bo.Categorie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil Connecté</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
	</head>
	<body>
	<div>
		<%@include file="fragments/header.jspf" %>
		<h4>Bienvenue ${sessionScope.pseudo} - ${sessionScope.id}</h4>
		<a href="">Encheres</a>
		<a href="<%=request.getContextPath()%>/NouvelleVente">Vendre un article</a>
		<a href="<%=request.getContextPath()%>/AfficherProfil">Mon profil</a>
		<a href="<%=request.getContextPath()%>/Accueil">Deconnexion</a>
	</div>
	<h3> Liste des enchères</h3>
	
	<form action="<%=request.getContextPath()%>/FiltreRecherche" method="post">
	<input type="text" id="contient" name ="contient" value="le nom de l'article contient">
	<p>Catégorie : <select name="categorie" id="categorie">
    <option  value="0">---- Choisir une categorie ----</option>
    <% List<Categorie> list2 = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list2){ %>
    	<option  value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%}
    %>
    <!-- Filtre checkbox -->
    			<div style="display: flex; flex-direction: row;">
				<input type="checkbox" id="achat" name="achat">
				<label for="achats">Achats</label>
					<ul style="list-style: none;">
						<li><input type="checkbox" id="enchères ouvertes" name="enchères ouvertes"><label for="enchères ouvertes">enchères ouvertes</label></li>
						<li><input type="checkbox" id="mesencheres" name="mesencheres"><label for="mesencheres">mes enchères</label></li>
						<li><input type="checkbox" id="mesemcheresremportees" name="mesemcheresremportees"><label for="mesemcheresremportees">mes emchères remportées</label></li>
					</ul>
				<input type="checkbox" id="vente" name="vente">
				<label for="achats">Mes vente</label>
					<ul style="list-style: none;">
						<li><input type="checkbox" id="checkbox" name="checkbox" value="mesventesencours"><label for="mesventesencours">mes ventes en cours</label></li>
						<li><input type="checkbox" id="checkbox" name="checkbox" value="ventesnondebutees"><label for="ventesnondebutees">ventes non debutées</label></li>
						<li><input type="checkbox" id="checkbox" name="checkbox" value ="ventesterminees"><label for="ventesterminees">ventes terminées</label></li>
					</ul>
			</div>
		<input type="submit" id="recherche" name ="recherche" value="recherche">
	</form>

	<div class="row row-cols-xxl-6 row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2">	
    <% List<Vente> list = (List<Vente>)request.getAttribute("listeEnchere");
    for (Vente art : list){ 
    	if (list !=null) {
    	int noArticle = art.getIdEnchere();%>
    	<div class="col">
    		<div class="p-4 card border-warning bg-dark mb-3" style="max-width: 18rem;">
  				<div class="card-header">Vendeur : <a href="./Show/Vendeur?name=<%=art.getPseudo()%>"><%=art.getPseudo()%></a></div>
  					<div class="card-body">
    					<h5 class="card-title"><a href="<%=request.getContextPath()%>/DetailVente?name=<%=art.getIdEnchere()%>"><%=art.getArticle()%></a></h5>
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