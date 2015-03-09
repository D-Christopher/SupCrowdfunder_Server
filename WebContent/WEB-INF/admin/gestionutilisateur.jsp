<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<c:import url="/WEB-INF/menu2.jsp" />
</head>
<body>
<div  class="well">
<center>
<br/>
<table class="table table-striped table-bordered" style="width: 750px">
        <thead>
        
        <tr>
            <th colspan="6">UTILISATEURS - Nombre total d'utilisateurs : ${nbUtilisateur}</th>
        </tr>
        <tr>
        	<th>Nom</th>
            <th>Prénom</th>
            <th>Mail</th>
            <th><center>Supprimer</center></th>
          
        </tr>
        </thead>
        <tbody >
        <c:forEach items="${requestScope.utilisateur}" var="u">
        <tr>
        <td>${u.nom_utilisateur}</td>
        <td>${u.prenom_utilisateur}</td>
        <td>${u.mail_utilisateur}</td>
        <td><center><a href="/SupCrowdfunder/admin/gestionutilisateur?id=${u.id_utilisateur}" class="btn btn-danger btn-lg active" role="button">Supprimer</a></center></td>
       
		</tr>
		</c:forEach>
        </tbody>
      </table>
</center>

</table>

</div>
</body>
</html>