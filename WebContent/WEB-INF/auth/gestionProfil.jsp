<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Gestion profil</title>
<c:import url="/menu.jsp" />
</head>
<body>
<div class="well">

	
	<h1>Gestion du profil</h1><br/>
	
	<form action="gestionProfil" method="post">
	
	  <input type="text" name="changer_mail"  placeholder="Nouvelle adresse mail"></br>
	  
	  <input type="password" name="password"  placeholder="Mot de passe actuel"></br>
	  <input type="password" name="new_password" pattern="(?=^.{6,}$).*$" placeholder="Nouveau mot de passe">
	  <input type="password" name="verif_pass" pattern="(?=^.{6,}$).*$" placeholder="Vérification"></br>
	  <button type="submit" value="submit">Valider</button>
	</form>
	</div>
</body>
</html>