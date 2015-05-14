<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
.lableWidth label{
	width: 40px;
}

.lableWidth{
	margin-bottom: 5px;
}
</style>
</head>
<body>
  <div align="center">
	<h3>User Registration</h3>
	<form action="<%=request.getContextPath()%>/user/save" method="post">
		<div class="lableWidth">
			<label>User Id :</label> <input type="text" id="userId" name="userId" />
		</div>
		<div class="lableWidth">
			<label>First Name :</label> <input type="text" id="firstName"
				name="firstName" />
		</div>
		<div class="lableWidth">
			<label>Last Name :</label> <input type="text" id="lastName"
				name="lastName" />
		</div>
		<div class="lableWidth">
			<label>User Name :</label> <input type="text" id="userName"
				name="userName" />
		</div>
		<div class="lableWidth">
			<label>Password :</label> <input type="text" id="password"
				name="password" />
		</div>
		<div class="lableWidth">
			<label>Age :</label> <input type="text" id="age" name="age" />
		</div>
		<input type="submit" value="Submit" />
	</form>
  </div>
</body>
</html>