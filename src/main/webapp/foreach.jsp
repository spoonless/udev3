<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<ul>
		<c:forEach items="${paramValues['nom']}" var="nom">
			<li><c:out value="${nom}"/></li>
		</c:forEach>
	</ul>
</body>
</html>