<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation Form</title>
</head>

<body>
	The student is confirmed: ${student.firstName} ${student.lastName }
	<br><br>
	Country: ${student.contry}
</body>
</html>