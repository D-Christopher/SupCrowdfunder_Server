<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>

<title>Administrateur</title>
<c:import url="/WEB-INF/menu2.jsp" />

</head>
<body>

<div class="well">

<center>
<br/>
<table class="table table-striped table-bordered" style="width: 720px; font-size:12px">
        <thead>
        
        <tr>
            <th colspan="6" style="font-size:15px">PROJETS - Nombre total de projets : ${nbProjet}</th>
        </tr>
        <tr>
        	<th>Titre</th>
            <th>Catégorie</th>
            <th>Createur</th>
            <th>Argent actuel</th>
            <th>Objectif</th>
            <th>Date création</th>
            <th>Date fin</th>
            <th>Editer</th>
            <th>Supprimer</th>
          
        </tr>
        </thead>
        <tbody >
        
        <c:forEach items="${sessionScope.projet}" var="p">
        	<tr>
			<td>${p.titre_projet}</div></td>
			<td>${p.categorie.nom_categorie}</td>
	        <td>${p.utilisateur.prenom_utilisateur} ${p.utilisateur.nom_utilisateur}</td>
	        <td>${p.argent_actuel_projet}€</td>
	        <td>${p.argent_objectif_projet}€</td>
	        <td>${p.date_creation_projet}</td>
	        <td>${p.date_limite_projet}</td>
	        <td><a href="/SupCrowdfunder/admin/editionprojet?id=${p.id_projet}" class="btn btn-info">editer</a></td>
	        <td><a href="/SupCrowdfunder/admin?id=${p.id_projet}" class="btn btn-danger">supprimer</a></td>
			</tr>
		</c:forEach>
        
        </tbody>
      </table>
</center>
</div>
</body>
</html>