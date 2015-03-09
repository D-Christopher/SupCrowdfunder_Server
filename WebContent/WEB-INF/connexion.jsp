<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Connexion</title>
<c:import url="/menu.jsp" />
</head>
<body>
<div class="well">
	<h1>Connexion</h1>
	
	<c:out value="${messageErreur}" />
	
	<form action="connexion" method="POST"><br/>
	  E-mail : <input type="email" name="mail" style="width:200px" required> <br/><br/>
	 Mot de passe : <input type="password" name="password" style="margin-right:65px; width:200px" required><br/><br/>
	  <button type="submit" class="btn btn-primary" value="submit">Connexion</button>
	</form>
	</div>
</body>
</html>