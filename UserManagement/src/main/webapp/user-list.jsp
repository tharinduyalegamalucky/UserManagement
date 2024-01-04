<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Management Application</title>


<!-- Bootstrap Link -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"crossorigin="anonymous">
 
</head>
<body>

	<header>
		<nav class = "navbar navbar-expand-md navbar-dark"
		style="background-color: blue">
		
		<div>
			<a href = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.iconfinder.com%2Ficons%2F3935309%2Fuser_admin_icon&psig=AOvVaw281l4pZWD9SZqq7yKm9SgG&ust=1704435540307000&source=images&cd=vfe&ved=0CBIQjRxqFwoTCID_lLKKw4MDFQAAAAAdAAAAABAE" class="navbar-brand">
			User Management Application</a>
		</div>
		
		
		<!-- Nav Bar -->
		
		<ul class="navbar-nav">
			<li>
			<a href="<%request.getContextPath();%>/list"
			
			class="nav-link">User List</a>
			
			</li>
		</ul>
		</nav>
	</header>
	
	<br>
	
	<div class="row">
	
<!--  	<div class = "alert alert-success" *ngIf='message'>{{message}}</div>  -->
	
	<div class = "container">
		<h3 class = "text-center">List of Users</h3>
		<hr>
		
		<div class = "container text-left">
			
			<a href="<%=request.getContextPath() %>/new" class="btn btn-success">Add New User</a>
			
		</div>
		<br>
		
		<table class = "table table-bordered">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Email</td>
					<td>Country</td>
					<td>Actions</td>
				</tr>
			</table>
			
			<tbody>
				
				<c:forEach var = "user" items = "${listUser}">
				
				<tr>
					<td><c:out value="${user.id }" /></td>
					<td><c:out value="${user.name }" /></td>
					<td><c:out value="${user.email }" /></td>
					<td><c:out value="${user.country }" /></td>
					
					<td>
					
					<a href = "edit?id = <c:out value = '${user.id}' />"> Edit </a>
					
						&nbsp;&nbsp;&nbsp;&nbsp; 
						
					<a href = "delete?id = <c:out value = '${user.id}' />"> Delete </a>
					
				</tr>
				
				</c:forEach>
				
			</tbody>
	</div>
	</div>
	
	

</body>
</html>