<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@include file="fragments/header.jspf" %>
	<h3>Nouvelle vente</h3>	

<form action="<%=request.getContextPath()%>/EnregistrerNouvelleVente" method="post">
		<p>Article</p>
		<input type="text" id="name" name="article" required>		
		<p>Description</p>
		<input type="text" id="name" name="description" required>	
		<p>Catégorie</p>
		<input type="text" id="name" name="catégorie" required>		
		<p>Photo de l'article</p>
		<input type="text" id="name" name="photo">		
		<p>Mise à prix</p>
		<input type="number" id="name" name="prixdepart" required>		
		<p>Début de l'enchère</p>
		<input type="date" id="name" name="debutenchere" required>		
		<p>Fin de l'enchère</p>
		<input type="date" id="name" name="finenchere" required>

	
<!-- 	<style>
      table,
     {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
    </style> -->
    
    <table>
    	<tr>
    		<th>Retrait</th>    
    		<td><p>Rue :</p>
				<input type="text" id="name" name="rue" required>
			</td>			
			<td><p>Code Postal :</p>
				<input type="text" id="name" name="cp" required>
			</td>			
			<td><p>Ville :</p>
				<input type="text" id="name" name="ville" required>
			</td>    		
    	</tr>
    </table>
	
	<button  type="submit" submit="Valider" id="submit" >Enregistrer</button>	
</form>	
	
	<form action="./AccueilConnecter.jsp" method="post">
	<button  type="submit" submit="Valider" id="submit" >Annuler</button>		
	</form>	
	
	
	

</body>
</html>