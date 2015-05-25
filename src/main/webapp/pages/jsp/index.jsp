<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h2>Index Page For Spring MVC</h2>
	<div>
		<div>
			<a href='<%=request.getContextPath()%>/userWeb/registration?editMode=false'>User Registration</a>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/userWeb/view">User Search</a>
		</div>
	</div>

</body>
</html>