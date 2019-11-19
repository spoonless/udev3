<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set value="${0}" var="resultat"/>
	
	<c:forEach items="${paramValues['nombre']}" var="nombre">
		<c:set value="${resultat + T(java.lang.Integer).parseInt(nombre) }" var="resultat"/>
	</c:forEach>

	${resultat }
</body>
</html>