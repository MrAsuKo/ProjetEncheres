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
		<p>Meilleure offre : <%=art.getPrixvente()%></p>
		<p>Mise à prix : <%=art.getPrixdepart()%></p>
		<p>Fin de l'enchère : <%=art.getFinenchere()%></p>
		<p>Retrait :</p>
		<p>Vendeur : <%=art.getPseudo()%></p>
		
		<%}
    	}
    }
    %>
		<form action="" method="post">
			<p>Offre : <input type="number" id="offre" name="offre"></p>
			<input type="submit" id="encherir" name ="encherir" value="Enchérir">
		</form>
	</body>
</html>