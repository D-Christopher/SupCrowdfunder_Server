<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="all" type="text/css" href="/SupCrowdfunder/css/bootstrap.css" />
<title>Accueil</title>
</head>
<body>
	
	<c:import url="/menu.jsp" />
	<div class ="well">
	
	<h2>Bonjour ${ !empty prenom_utilisateur ? prenom_utilisateur : "invité" }</h2>
	
	<p>Liste des projets</p>
	
	<form action="/SupCrowdfunder/accueil" method="post">
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
	<div class="projetCategorie">${p.categorie.nom_categorie}</div>
	<div class="projetDescription">${p.description_projet}</div><br/>	
	<div class="projetDatelimite">Date de fin : ${p.date_limite_projet}</div></br>
	<div id="progress progress-striped well">
    <p> ${p.argent_actuel_projet} € / ${p.argent_objectif_projet}€ (${p.argent_actuel_projet*100/p.argent_objectif_projet}%)
	<progress name="progress" value="${p.argent_actuel_projet}" min="0" max="${p.argent_objectif_projet}"></progress></p>
	<form action="/SupCrowdfunder/detailprojet?id=${p.id_projet}" method="post">
		<input type="submit" class="btn btn-info" value="Voir détails"/>
	</form>

</div>		
	</article>
	 
</c:forEach>
</section>
	</div>
</body>
</html>