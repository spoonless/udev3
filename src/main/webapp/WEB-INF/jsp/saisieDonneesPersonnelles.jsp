<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE - Exemple MVC</title>
  </head>
  <body>
  	<form action="" accept-charset="utf-8" method="post">
  		<label>Civilite :</label>
  		<select name="civilite">
  			<option value="">--</option>
  			<c:forEach items="${civilites}" var="c">
  				<option ${param['civilite'] == c ? "selected" : ""}><c:out value="${c}"/></option>
  			</c:forEach>
  		</select>
  		<br>
  		<label>Nom :</label>
  		<input type="text" name="nom" value="<c:out value="${param['nom']}"/>">
  		<c:out value="${erreurs.erreurNom}"/>
  		<br>
  		<label>Age :</label>
  		<input type="text" name="age" value="<c:out value="${param['age']}"/>">
  		<c:out value="${erreurs.erreurAge}"/>
  		<br>
  		<label>Email :</label>
  		<input type="text" name="email" value="<c:out value="${param['email']}"/>">
  		<c:out value="${erreurs.erreurEmail}"/>
  		<br>
  		<input type="submit">
  	</form>
	<div>
	  	<a href='<c:url value="/"/>'>Retour à l'accueil</a>  
	</div>
  </body>
</html>
