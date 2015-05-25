<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.3.min.js"></script>
<title>User Registration</title>
<style type="text/css">
.lableWidth label{
	width: 40px;
}

.lableWidth{
	margin-bottom: 5px;
}
</style>
<script type="text/javascript">
	$(function(){
		var userId='<%=request.getParameter("userId")%>';
		editMode=<%=request.getParameter("editMode")%>;
		if(userId != null){
			var user={};
			user.id=userId;
			$.ajax({
				type : "POST",
				url : "/SpringMvcAppDemo/user/findById",
				data : JSON.stringify(user),
				contentType : 'application/json',
				success : function(data) {
					console.log(JSON.stringify(data));
					setUserDetail(data);
				},
				error : function() {
					alert('<p>An error has occurred</p>');
				},
			});
		}
	});
	
	function setUserDetail(user){
		$('#userId').val(user.userId);
		$('#firstName').val(user.firstName);
		$('#lastName').val(user.lastName);
		$('#userName').val(user.userName);
		$('#password').val(user.password);
		$('#age').val(user.age);
	}
	
	function addUser(){
		var url="/SpringMvcAppDemo/user/save";
		if(editMode){
			url="/SpringMvcAppDemo/user/update";
		}
		var user=new Object();
			user.userId=$('#userId').val();
			user.firstName=$('#firstName').val();
			user.lastName=$('#lastName').val();
			user.userName=$('#userName').val();
			user.password=$('#password').val();
			user.age=$('#age').val();
		$.ajax({
			type : "POST",
			url : url,
			data : JSON.stringify(user),
			contentType : 'application/json',
			success : function(data) {
				location.href='<%=request.getContextPath()%>/userWeb/view';
			},
			error : function() {
				alert('<p>An error has occurred</p>');
			},
		});
	}

</script>
</head>
<body>
	<div align="left">
		<a href="<%=request.getContextPath()%>/userWeb/view">User Search</a>
	</div>
  <div align="center">
	<h3>User Registration</h3>
<%-- 	<form action="<%=request.getContextPath()%>/user/save" method="post"> --%>
	<form action="#">
		<div class="lableWidth">
			<label>User Id :</label> <input type="text" id="userId"/>
		</div>
		<div class="lableWidth">
			<label>First Name :</label> <input type="text" id="firstName"
				 />
		</div>
		<div class="lableWidth">
			<label>Last Name :</label> <input type="text" id="lastName"
				 />
		</div>
		<div class="lableWidth">
			<label>User Name :</label> <input type="text" id="userName"
				 />
		</div>
		<div class="lableWidth">
			<label>Password :</label> <input type="password" id="password"
				 />
		</div>
		<div class="lableWidth">
			<label>Age :</label> <input type="text" id="age" name="age" />
		</div>
		<input type="button" value="Submit" onclick="addUser()" />
	</form>
  </div>
</body>
</html>