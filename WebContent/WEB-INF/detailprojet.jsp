<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Detail du projet</title>
<c:import url="/menu.jsp" />
</head>
<body>
<div class="well">


<u>Titre :</u><br/> ${requestScope.titre }</br><br/>

<u>Description :<br/></u> ${requestScope.description }</br><br/>

<u>Recompense :<br/></u> ${requestScope.recompense }</br><br/>

<u>Argent actuel :<br/></u> ${requestScope.argentActu }</br><br/>

<u>Argent objectif :<br/></u> ${requestScope.argentObj }</br><br/>

<u>Catégorie du projet :</u> <div style="color:orange"> ${requestScope.categorieProjet}</div></br><br/>

<u>Date de création :<br/></u> ${requestScope.dateCrea}</br><br/>

<u>Date de fin :<br/></u> ${requestScope.dateLimite}</br><br/>

<a href="/SupCrowdfunder/auth/don?id=${requestScope.idProjet}" class="btn btn-info">Faire un don</a>
</div>
</body>
</html>