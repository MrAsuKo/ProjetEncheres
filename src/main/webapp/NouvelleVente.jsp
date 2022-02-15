<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente</title>
</head>
<body>

<p>Modifier les liens</p>
<h1>Eni-Enchères</h1>
	<h3>Nouvelle vente</h3>
	
	
	<section>
		<p>Article</p>
		<input type="text" id="name" name="Article" required>
		
		<p>Description</p>
		<input type="text" id="name" name="Article" required>
	</section>
	
	
	<section>
		<p>Catégorie</p>
		<input type="text" id="name" name="Article" required>
		
		<p>Photo de l'article</p>
		<input type="text" id="name" name="Article" required>
		
		<p>Mise à prix</p>
		<input type="text" id="name" name="Article" required>
		
		<p>Début de l'enchère</p>
		<input type="text" id="name" name="Article" required>
		
		<p>Fin de l'enchère</p>
		<input type="text" id="name" name="Article" required>
	</section>
	
	<style>
      table,
     {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
    </style>
    
    <table>
    	<tr>
    		<th>Retrait</th>
    
    		<td><p>Rue :</p>
				<input type="text" id="name" name="Article" required>
			</td>
			
			<td><p>Code Postal :</p>
				<input type="text" id="name" name="Article" required>
			</td>
			
			<td><p>Ville :</p>
				<input type="text" id="name" name="Article" required>
			</td>
    		
    	</tr>
    </table>
	
	<form action="./AccueilConnecter.jsp" method="post">
		
		<button  type="submit" submit="Valider" id="submit" >Enregistrer</button>
		
	</form>	
	
	<form action="./AccueilConnecter.jsp" method="post">
		
		<button  type="submit" submit="Valider" id="submit" >Annuler</button>
		
	</form>	
	
	
	

</body>
</html>