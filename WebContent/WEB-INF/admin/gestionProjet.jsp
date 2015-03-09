<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="all" type="text/css" href="/SupCrowdfunder/css/bootstrap.css" />
<title>Gestion des projets</title>
</head>
<body>
	
	<c:import url="/menu.jsp" />
	<div class ="well">
	
	<h2>Bonjour ${ !empty prenom ? prenom : "invité" }</h2>
	
	<p>Liste des projets</p>
	
	<form action="/SupCrowdfunder/admin/gestionprojet" method="post">
Choisir une catégorie :
<select name="categorie" size="1">
<option value="0">Toutes les categories</option>

<c:forEach items="${requestScope.categorie}" var="c">
	
	<option value="${c.id_categorie}">${c.nom_categorie}</option>
	 
</c:forEach>
</div>
</select>
<input type="submit"/>
</form>
   
<section>         		
<c:forEach items="${sessionScope.projet}" var="p">
	
	<article>
	<div class="projetTitre">${p.titre_projet}</div>
	<div class="projetCategorie">"Cinéma"</div>
	<div class="projetDescription">${p.description_projet}</div><br/>
	<div class="projetObjectif">Objectif : ${p.argent_objectif_projet}€</div>	
	<div class="projetDatelimite">Date de fin : ${p.date_limite_projet}</div>		
	<a href="/SupCrowdfunder/admin/gestionprojet?id=${p.id_projet}">supprimer</a>
	<a href="/SupCrowdfunder/admin/editionprojet?id=${p.id_projet}">editer</a>
	</article>
	 
</c:forEach>
</section>
	</div>
</body>
</html>