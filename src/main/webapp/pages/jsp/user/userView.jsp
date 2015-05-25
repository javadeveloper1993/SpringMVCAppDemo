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
	
	$(function(){
		findUser();
	});
	
	function findUser(){
		var user={};
		if($("#userIdText").val()!=""){
			user.userId=$("#userIdText").val();
		}
		$.ajax({
			type : "POST",
			url : "/SpringMvcAppDemo/user/get",
			data : JSON.stringify(user),
			contentType : 'application/json',
			success : function(data) {
				if(data==""){
					$('#userTable').html("<table><tr><td colspan=7>No Data Found.</td></tr></table>");
				}else{
					setUserData(data);					
				}
			},
			error : function() {
				alert('<p>An error has occurred</p>');
			},
		});
	}
	
	function setUserData(userList){
		var html="";
		$.each(userList,function(){
			html+=createDynamicViewuser(this);
		});
		$('#userTable').html(html);
	}
	
	function createDynamicViewuser(user){
		var tableData="<tr><td>"
					 + user.userId				 
					 +"</td>"
					 +"<td>"
					 + 	user.firstName				 
					 +"</td>"
					 +"<td>"
					 + user.lastName				 
					 +"</td>"
					 +"<td>"
					 + user.userName			 
					 +"</td>"
					 +"<td>"
					 + user.password				 
					 +"</td>"
					 +"<td>"
					 + user.age				 
					 +"</td>"
					 +"<td>"
					 + '<input type=button value=Delete onclick=removeUser("'+user.id+'")>'
					 + '<input type=button value=Update onclick=updateUser("'+user.id+'")>'
					 +"</td>"
					 +"</tr>";
		 return tableData;
	}
	
	function removeUser(userId){
		var user={};
		user.id=userId;
		$.ajax({
			type : "POST",
			url : "/SpringMvcAppDemo/user/remove",
			data : JSON.stringify(user),
			contentType : 'application/json',
			success : function(data) {
				console.log(JSON.stringify(data));
				findUser();
			},
			error : function(xhr, status, error) {
				alert('<p>An error has occurred</p>' +  xhr.responseTex);
			},
		});
	}
	
	function updateUser(userId){
		location.href='<%=request.getContextPath()%>/userWeb/registration?userId='+userId+'&editMode=true';
// 		$.ajax({
// 			type : "POST",
// 			url : "/SpringMvcAppDemo/user/get",
// 			data : JSON.stringify(user),
// 			contentType : 'application/json',
// 			success : function(data) {
// 			},
// 			error : function(xhr, status, error) {
// 				alert('<p>An error has occurred</p>' +  xhr.responseTex);
// 			},
// 		});
	}
	
</script>
</head>
<body>
	<div align="left">
		<a href='<%=request.getContextPath()%>/userWeb/registration?editMode=false'>User Registration</a>
	</div>
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
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="userTable">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>