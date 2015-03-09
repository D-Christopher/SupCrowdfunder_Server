<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="all" type="text/css" href="/SupCrowdfunder/css/bootstrap.css" />
<title>Edition Projet</title>
<c:import url="/menu.jsp" />
</head>
<body>
	<div class="well">
	
	
	<p>Modifier un projet</p>
	<br/>
	
	<form action="editionprojet" method="post">
	
		Nom du Projet : <input type="text" name="titre" style="width:200px; margin-right:48px"  value="${requestScope.titre }" required></br><br/>
		
		<div style="margin-left:25px">Description du Projet : <textarea rows="4" cols="30" name="descriptProjet"   >${requestScope.description }</textarea></div></br><br/>
		
		<div style="margin-right:50px">Description des Récompenses : <textarea rows="4" cols="30" name="descriptRecompense"  >${requestScope.recompense }</textarea></div></br><br/>
		
		<div style="margin-left:10px">Objectif : <input type="text" style="width:200px" name="objectif"  value="${requestScope.argent }" required></div></br><br/>
		
		Catégorie du projet : ${requestScope.categorieProjet}
		</br><br/>
		
		Choisir la catégorie : 
		<select name="categorie" size="1" style="width:200px; margin-right : 85px" required>
		<option ></option>
		<c:forEach items="${requestScope.categorie}" var="c">
			<option value="${c.id_categorie}">${c.nom_categorie}</option>
	 
		</c:forEach>
		</select>
		
	  	</br><br/>
		
		<button type="submit" value="submit" class="btn btn-primary">Modifier</button>
	</form>
	</div>
</body>
</html>