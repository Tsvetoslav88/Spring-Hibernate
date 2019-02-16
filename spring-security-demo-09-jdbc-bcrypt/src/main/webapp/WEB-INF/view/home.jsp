<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<title>Vexelon Home Page</title>
</head>
<body>
	<h2>Vexelon Home Page</h2>

	<p>
	Welcome to Vexelon Home Page
	</p>
	
	<hr>
	
	<!-- Display username and role -->
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
		
		<!-- Add a link to point to /leaders ... this is for managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(Only for Manager peers)
		</p>
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMINISTRATOR')">
	
		<!-- Add a link to point to /systems ... this is for admins-->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>
			(Only for Admin peers)
		</p>
	</security:authorize>
	
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	
	</form:form>
	
	
</body>
</html>