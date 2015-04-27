<!DOCTYPE html>
<html>
<head>
<title>Model And Session Attribute</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.2.1.3.min.js"></script>
</head>
<body>
	<div id="person1"></div>
	<br>
	<div id="person2"></div>
	<script type="text/javascript">
		var person='<%=request.getAttribute("person")%>';
		alert(JSON.stringify(person));
		$('#person1').html(JSON.stringify(person));
		var person1="<%=request.getSession().getAttribute("personSession")%>";
		$('#person2').html(JSON.stringify(person1));
	</script>
</body>
</html>