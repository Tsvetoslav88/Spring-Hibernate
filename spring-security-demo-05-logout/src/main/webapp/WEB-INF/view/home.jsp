<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Vexelon Home Page</title>
</head>
<body>
	<h2>Vexelon Home Page</h2>

	<p>
	Welcome to Vexelon Home Page
	</p>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	
	</form:form>
	
	
</body>
</html>