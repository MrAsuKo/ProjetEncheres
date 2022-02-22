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
	<input type="text" id="contient" name ="contient" value="le nom de l'article contient">
	<p>Catégorie : <select name="categorie" id="categorie">
    <option  value="0">---- Choisir une categorie ----</option>
    <% List<Categorie> list2 = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list2){ %>
    	<option  value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%}
    %>
		<input type="submit" id="recherche" name ="recherche" value="recherche">
	</form>

		

<div>	
    <% List<Vente> list = (List<Vente>)request.getAttribute("listeEnchere");
    for (Vente art : list){ 
    	if (list !=null) {
    	int noArticle = art.getIdEnchere();%>
    	<div style="border:solid; width: 300px ; margin:10px">
    	<p><%=art.getArticle()%></p><p>Prix : <%=art.getPrixdepart()%></p><p>fin de l'enchère : <%=art.getFinenchere()%></p><p>Vendeur : <%=art.getPseudo()%></p>
    	</div>
    <%}
    }
    %>
</div>   

	</body>
</html>