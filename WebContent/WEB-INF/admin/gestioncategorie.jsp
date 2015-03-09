<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Gestion des catégories</title>
<c:import url="/WEB-INF/menu2.jsp" />
</head>

<body>
<div class="well">



<form action="/SupCrowdfunder/admin/gestioncategorie" method="post">
<label>Ajoutez une catégorie :  </label>
<input type="text" name="nouvelleCategorie"/>
<input type="submit" value="Ajouter"/>



<center>
<br/>
<table class="table table-striped table-bordered" style="width: 750px">
        <thead>
        
        <tr>
            <th colspan="6">CATEGORIES - Nombre total de catégories : ${nbCategorie}</th>
        </tr>
        <tr>
        	<th>Nom de la catégorie</th>
            <th><center>Supprimer</center></th>
          
        </tr>
        </thead>
        <tbody >
        <c:forEach items="${requestScope.categorie}" var="c">
        <tr>
        <td>${c.nom_categorie}</td>
        <td><center><a href="/SupCrowdfunder/admin/gestioncategorie?id=${c.id_categorie}" class="btn btn-danger btn-lg active" role="button">Supprimer</a></center></td>
       
		</tr>
		</c:forEach>
        </tbody>
      </table>
</center>
</form>

</div>
</body>
</html>