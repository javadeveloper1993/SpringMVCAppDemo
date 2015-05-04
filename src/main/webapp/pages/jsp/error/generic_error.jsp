<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generic Expetion Page</title>
</head>
<body>
	<div align="center"><h1>Error Page</h1></div>
	<h3>Date :: ${date}</h3>
	<h3>Request URL :: ${url}</h3>
	<h3>Status :: ${errCode}</h3>
	<h3>Error Message :: ${errMsg}</h3>
	<h3>Class Name:: ${className}</h3>
	<h3>Stack Trace :: </h3>
	<c:forEach items="${stackTrace}" var="ste">
    	${ste}
	</c:forEach>
</body>
</html>