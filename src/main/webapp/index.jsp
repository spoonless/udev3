<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<c:url value="/produit.html" var="produit"/>
	<c:url value="/trace.jsp" var="trace"/>
	<c:url value="/date.jsp" var="date"/>
	<c:url value="/date_format.jsp" var="date_format"/>
	<c:url value="/nombre.jsp" var="nombre"/>
	<c:url value="/foreach.jsp?nom=David&nom=Eric&nom=Michel&nom=Robert" var="foreach"/>
	<c:url value="/addition.jsp?nombre=1&nombre=2&nombre=3" var="addition"/>

	<ul>
		<li><a href="${produit}">Le produit avec le code barre</a></li>
		<li><a href="${trace}">Une page JSP avec des infos de la requête</a></li>
		<li><a href="${date}">La date avec un format fixe</a></li>
		<li><a href="${date_format}">La date au format qui s'adapte aux préférences du navigateur</a></li>
		<li><a href="${nombre}">Un nombre au format qui s'adapte aux préférences du navigateur</a></li>
		<li><a href="${foreach}">L'affichage d'une liste avec foreach</a></li>
		<li><a href="${addition}">Une JSP qui fait des additions</a></li>
	</ul>

</body>
</html>