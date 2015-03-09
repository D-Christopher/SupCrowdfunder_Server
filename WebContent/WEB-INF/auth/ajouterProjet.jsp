<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Créer projet</title>
<c:import url="/menu.jsp" />
</head>
<body>
	<div class="well">
	
	
	<p>Créer un projet</p>
	
	<form action="ajouterProjet" method="post">
	
		<input type="text" name="titre"  placeholder="Titre du projet" required></br>
		
		<textarea rows="4" cols="30" name="descriptProjet" placeholder="Description du projet" required></textarea></br>
		
		<textarea rows="4" cols="30" name="descriptRecompense" placeholder="Description des récompenses" ></textarea></br>
		
		<input type=""number"" name="objectif" pattern="[0-9]+" placeholder="Objectif ($)" required></br>
		
		<label for="date_limite">Date de fin</label>
		<input type="date" name="date_limite"></br>
		
		<label>choisir la catégorie</label>
		<select name="categorie" size="1">
		<c:forEach items="${requestScope.categorie}" var="c">
			<option value="${c.id_categorie}">${c.nom_categorie}</option>
	 
		</c:forEach>
		</select>
		
	  	</br>
		
		<button type="submit" value="submit">Créer</button>
	</form>
	</div>
</body>
</html>