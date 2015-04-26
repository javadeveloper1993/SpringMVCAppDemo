<!DOCTYPE html>
<html>
<head>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.2.1.3.min.js"></script>
<title>Request Body Annotation Example</title>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "POST",
			url : "/SpringMvcAppDemo/rqbody/entiry",
			data : JSON.stringify({
				name : "Patel Maulik J",
				age : 21,
				id : "002"
			}),
			contentType : 'application/json',
			headers : {
				"entity" : "MyEntity"
			},
			success : function(data) {
				console.log(">>>> :: " + JSON.stringify(data));
			},
			error : function() {
				alert('<p>An error has occurred</p>');
			},
		});
	});
</script>
</head>
<body>
</body>
</html>