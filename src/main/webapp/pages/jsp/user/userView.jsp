<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.3.min.js"></script>
<title>User Detail</title>
<style type="text/css">

td,th {
	padding: 5px;
	text-align: center;
}

</style>
<script type="text/javascript">
	var userId=<%=request.getParameter("userId")%>;
	
	function findUser(){
		var user={};
		user.userId=$("#userIdText").val();
		$.ajax({
			type : "POST",
			url : "/SpringMvcAppDemo/user/get",
			data : JSON.stringify(user),
			contentType : 'application/json',
			success : function(data) {
				if(data==""){
					$('#userTable').html("<table><tr><td colspan=6>No Data Found.</td></tr></table>");
				}else{
					setUserData(data);					
				}
			},
			error : function() {
				alert('<p>An error has occurred</p>');
			},
		});
	}
	
	function setUserData(user){
		var tableData="<table>"
					 +"<tr><td>"
					 + 	user.userId				 
					 +"</td>"
					 +"<td>"
					 + 	user.firstName				 
					 +"</td>"
					 +"<td>"
					 + 	user.lastName				 
					 +"</td>"
					 +"<td>"
					 + 	user.userName			 
					 +"</td>"
					 +"<td>"
					 + 	user.password				 
					 +"</td>"
					 +"<td>"
					 + 	user.age				 
					 +"</td>"
					 +"</table>";
		$('#userTable').html(tableData);
	}
</script>
</head>
<body>
	<div align="center">
		<h3>User Detail</h3>
		<div>
			<label>User Id : </label>
			<label>
				<input type="text" name="userId" id="userIdText">
			</label>
			<label>
				<input type="button" value="Search" onclick="findUser()">
			</label>
		</div>
		<br>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<thead>
					<tr>
						<th>User Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>UserName</th>
						<th>Password</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody id="userTable">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>