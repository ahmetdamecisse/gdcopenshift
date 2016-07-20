<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Accès refusé</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Vous n'êtes pas autorisés à accéder à cette page!</h2>
		</c:when>
		<c:otherwise>
			<h2>Utilisateur : ${username} <br/>Vous n'êtes pas autorisés à accéder à cette page!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>