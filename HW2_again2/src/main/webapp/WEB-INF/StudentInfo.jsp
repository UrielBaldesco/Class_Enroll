
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary mb-3">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">Art Class</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="StudentInfo">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="AddStudent">Enroll Student</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="DisplayGroup">Groups</a>
		        </li>
		      </ul>
		    </div>
		  </div>
	</nav>
    <h2 class="display-5 text-center">Student Information </h2>
   
    <div class="container">
    	<!-- <a href="AddStudent">Add Student</a> -->
    	<!-- <a href="AddStudent"><button type="button" class="btn btn-outline-primary">Add Student</button></a> -->
    	
    	<br>
    	<table class="table table-hover">
    		<tr>
				<th>Student</th>
				<th>Parent</th>
				<th>Email</th>
				<th>Age</th>
				<th>Group</th>
				<th></th>
			</tr>
		
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.parent}</td>
					<td>${student.parentEmail}</td>
					<td>${student.age}</td>
					<td>${student.groupName}</td>
					<td><a class="btn btn-primary" href="EditStudent?id=${student.id}" role="button">Edit</a></td>
				</tr>
			</c:forEach>
    	</table>
    </div>
    
    <div class="container text-center">
     	<a class="btn btn-outline-primary" href="AddStudent" role="button">Add Student</a>
    </div>
    
 
   
    
    <div class="text-center container mt-3">
		<!-- <a href="DisplayGroup">Groups</a> -->
		<!-- <a href="DisplayGroup"><button type="button" class="btn btn-outline-primary">Groups</button></a> -->
		<a class="btn btn-outline-primary" href="DisplayGroup" role="button">Groups</a>
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>