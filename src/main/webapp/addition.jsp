<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Somme</title>
</head>
<body>
	<c:set value="${0}" var="resultat"/>
	
	<c:forEach items="${paramValues['nombre']}" var="nombre">
		<c:set value="${resultat + nombre}" var="resultat"/>
	</c:forEach>

	<c:out value="${fn:join(paramValues['nombre'], ' + ')}"/> 
	= <c:out value="${resultat}"/>
</body>
</html>