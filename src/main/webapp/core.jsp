<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<c:out value="${param['nom']}"/>
	<c:url value="/date.jsp" var="lien"/>
	<a href="${lien}">Voir la date et l'heure</a>
</body>
</html>