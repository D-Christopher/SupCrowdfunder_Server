<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center>
<div class="navbar" style="width:777px">
<center>
    <div class="navbar-inner">
        <ul class="nav">
            <li>
                <a href="<c:url value="/accueil"/>">SupCrowdfunder</a>
            </li>
        </ul>
        
<c:if test="${ !empty prenom_utilisateur && admin == true }">
	<div class="container">
                        <ul class="nav pull-right">
			<li class="button">
                                <a href="<c:url value="/admin"/>">
                                    Admin
                                    <b class="button"></b>
                                </a>
			
            <li class="button">
                                <a href="<c:url value="/auth/ajouterProjet"/>">
                                    Créer un projet
                                    <b class="button"></b>
                                </a>
          	<li class="button">
                                <a href="<c:url value="/auth/gestionProfil"/>">
                                    Gestion Profil
                                    <b class="button"></b>
                                </a>
            <li class="divider-vertical"></li>

                            <li class="button">
                                <a href="<c:url value="/deconnexion"/>"
                                   class="">
                                    Deconnexion
                                    <b class="button"></b>
                                </a>

                        </ul>
      </div>
</c:if>

<c:if test="${ !empty prenom_utilisateur && admin == false }">
	<div class="container">
                        <ul class="nav pull-right">

            <li class="button">
                                <a href="<c:url value="/auth/ajouterProjet"/>">
                                    Créer un projet
                                    <b class="button"></b>
                                </a>
          	<li class="button">
                                <a href="<c:url value="/auth/gestionProfil"/>">
                                    Gestion Profil
                                    <b class="button"></b>
                                </a>
            <li class="divider-vertical"></li>

                            <li class="button">
                                <a href="<c:url value="/deconnexion"/>"
                                   class="">
                                    Deconnexion
                                    <b class="button"></b>
                                </a>

                        </ul>
      </div>
</c:if>
<c:if test="${ empty prenom_utilisateur }">
          
          <div class="container">
                        <ul class="nav pull-right">

            <li class="button">
                                <a href="<c:url value="/connexion"/>">
                                    Connexion
                                    <b class="button"></b>
                                </a>
            <li class="divider-vertical"></li>

                            <li class="button">
                                <a href="<c:url value="/inscription"/>"
                                   class="">
                                    Inscription
                                    <b class="button"></b>
                                </a>

                        </ul>
                       </div>
          </c:if>
                       </div>
                       </div>