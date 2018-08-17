<!DOCTYPE>
<html>
<head>

	<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>
<body>

<h2>Spring MVC Demo - Home Page</h2>

<hr><a href="hello/showForm">Hello World form</a> 

<br><br>

<hr><a href="student/showForm">Student form</a>

<br><br>

<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>
</body>

</html>