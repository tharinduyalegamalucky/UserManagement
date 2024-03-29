<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application</title>


<!-- Bootstrap Link -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<body>

	<header>
	
	<nav class="navbar navbar-expand-md navbar-dark" style = "background-color : blue">
	
	<div>
		<a href = "" class = "navbar-brand">User Management Application</a>	
	</div>
	
	<ul class = "navbar-nav">
		<li><a href = "<%=request.getContextPath() %>/list" class = "nav-link">Users</a></li>
	</ul>
	</nav>
	</header>
	
	<br>
	
	<div class = "container col-md-5">
	<div class = "card">
		<div class = "card-body">
			<c:if test = "${user != null }">
				<form action = "update" method = "post">
			</c:if>
			
			<c:if test = "${user == null }">
				<form action = "insert" method = "post">
			</c:if>
			
			
			<caption>
				<h2>
					<c:if test = "${user != null}">
						Edit User
					</c:if>
					<c:if test = "${user != null}">
						Add New User
					</c:if>
				</h2>
			</caption>
			
			
			<c:if test = "${user != null }">
				<input type = "hidden" name = "id" value = "<c:out value = '${user.id }'/>" />
			</c:if>
			
			<fieldSet class = "form-group">
				<label> User Name</label> <input type = "text"
					value = "<c:out value = '${user.name}' />" class = "form-control"
					name ="name" required = "required">
			</fieldSet>
			
			
			<fieldSet class = "form-group">
				<label> User Email</label> <input type = "text"
					value = "<c:out value = '${user.email}' />" class = "form-control"
					name ="email">
			</fieldSet>
			
			
			<fieldSet class = "form-group">
				<label> User Country</label> <input type = "text"
					value = "<c:out value = '${user.country}' />" class = "form-control"
					name ="country">
			</fieldSet>
			
			<button type = "submit" class = "btn btn-success">Save</button>
			
				</form>
		</div>
	</div>
		
	</div>


</body>
</html>