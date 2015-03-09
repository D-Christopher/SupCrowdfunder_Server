<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/SupCrowdfunder/css/bootstrap.css" type="text/css"/>
<title>Dons Projet</title>
<c:import url="/menu.jsp" />
</head>
<body>
<div class="well">



<form action="don" method="post">
<label>Montant du Don (€) :  </label><br/>
<input type="number" name ="don" placeholder="don en euros"/><br/><br/>
<input type="submit" class="btn btn-primary"/ >
</form>
</div>
</body>
</html>