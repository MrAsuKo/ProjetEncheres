<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet"> 
</head>
<body>
<%@include file="fragments/header.jspf" %>
<br>
	<h3>Nouvelle vente</h3>	
<br>
<form action="<%=request.getContextPath()%>/EnregistrerNouvelleVente" method="post">
<div class="row">
<div class="col-2">
		<p>Article : <input class="form-control me-2" type="text" id="name" name="article" required>	</p>	
		<p>Description : <input class="form-control me-2" type="text" id="name" name="description" required>	</p>

<p>Catégorie : <select class="form-select" name="categorie" id="categorie" required>
    <option  value="0">---- Choisir une categorie ----</option>
    <% List<Categorie> list = (List<Categorie>)request.getAttribute("listecategorie");
    for (Categorie cat : list){ %>
    	<option value="<%=cat.getNumcatego()%>"><%=cat.getLibelle()%></option>
    <%}
    %>
</select></p>
</div>
<div class="col-2">		
		<!-- <p>Photo de l'article : <input class="form-control me-2" type="file" id="name" name="photo"></p> -->	
		<p>Mise à prix : <input class="form-control me-2" type="number" id="number" name="prixdepart" min="1" required></p>	
		<p>Début de l'enchère : <input class="form-control me-2" type="date" id="date" name="debutenchere" min="<%=LocalDateTime.now().toLocalDate() %>" value="<%=LocalDateTime.now().toLocalDate() %>" required>	</p>	
		<p>Fin de l'enchère : <input class="form-control me-2" type="date" id="date" name="finenchere" min="<%=LocalDateTime.now().plusDays(1).toLocalDate() %>"required></p>

    </div>
    </div>
    <table class="p-3 card border-warning bg-dark mb-4" style="max-width: 770px;">
    	<tr>
    		<th>Retrait :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
    		<td><p>Rue :</p>
				<input class="form-control me-2" type="text" id="name" name="rue" placeholder=${sessionScope.rue} value=${sessionScope.rue}>
			</td>			
			<td><p>Code Postal :</p>
				<input class="form-control me-2" type="text" id="name" name="cp" placeholder=${sessionScope.cp} value=${sessionScope.cp}>
			</td>			
			<td><p>Ville :</p>
				<input class="form-control me-2" type="text" id="name" name="ville" placeholder=${sessionScope.ville} value=${sessionScope.ville}>
			</td>    		
    	</tr>
    </table>
   			 <%
			String message = "";
			if (request.getAttribute("message") != null) {
				message = (String)request.getAttribute("message");
			%>
			<p style="color:red"><%=message %></p>
			<%} %>
			
		<input class="btn btn-outline-warning position-absolute" type="submit" id="enregistrer" name ="enregistrer" value="Enregistrer">
	</form>	
	<form style="padding-left: 115px;" action="<%=request.getContextPath()%>/BackAccueil" method="post">
		<input class="btn btn-outline-warning" type="submit" id="annuler" name ="annuler" value="Annuler">
	</form>
</body>
</html>