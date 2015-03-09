<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Inscription</title>
<c:import url="/menu.jsp" />
</head>

<body>
<div class="well">
	<h1>Page d'inscription</h1>
	
	<form action="inscription" method="post">
		
	</br>
	<div style="margin-left:25px"> Nom : <input type="text" name="nom" pattern="[a-zA-Z]+" required style="width: 200px; margin-left:10px" required></div><br/>
	  Prénom : &nbsp <input type="text" pattern="[a-zA-Z]+" name="prenom"  style="width: 200px" required><br/>
	  <c:out value="${erreurLogin}" /></br>
	  
	  Mot de passe : &nbsp&nbsp<input type="password" pattern="(?=^.{5,}$).*$" name="password" style="width: 200px;margin-right:45px"   required><br/><br/>
	  Vérification : &nbsp&nbsp<input type="password" pattern="(?=^.{5,}$).*$" name="verif_pass"  style="width:200px; margin-right:25px" required><br/>
	  <c:out value="${erreurMdp}" />
	  <c:out value="${erreurMdpVide}" /></br>
	  
	  <div style="margin-left:10px">E-mail :&nbsp&nbsp<input type="email" name="mail" style="width:200px; margin-left:5px" required></div></br>
	  <button type="submit" class ="btn btn-primary" value="submit">Inscription</button>
	</form>
	</div>
</body>
</html>