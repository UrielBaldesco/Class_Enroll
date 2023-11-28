<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Student</title>
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
    <h2 class="display-5 text-center mb-3">Add Student</h2>
   
    <div class="container">
    <form method="post">
    	<div class="row g-3 mb-3 mt-3">
		  <div class="col">
		  	<label for="name" class="form-label">Student Name</label>
		    <input type="text" name="name" class="form-control" placeholder="First name" aria-label="First name">
		  </div>
		  <div class="col">
		  	<label for="parent" class="form-label">Parent Name</label>
		    <input type="text" name="parent" class="form-control" placeholder="Parent name" aria-label="Parent name">
		  </div>
		</div>
		
		<div class="row g-3 mb-3">
			<div class="col-12">
		  		<label for="parentEmail" class="form-label">Parent Email</label>
		    	<input type="text" name="parentEmail" class="form-control" placeholder="Parent Email" aria-label="Parent Email">
		  	</div>
		</div>
		
		<div class="row g-3 mb-3">
			<div class="col-3">
				<label for="age" class="form-label">Age</label>
		    	<input type="text" name="age" class="form-control" placeholder="Age" aria-label="age">
			</div>
			
			<div class="col-5">
				<label for="groupName" class="form-label">Choose Group</label>
				<select name="groupName" class="form-select">
					<c:forEach items="${groups}" var="group">
						<option value="${group.groupName}">${group.groupName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="col-12 mt-3 mb-3">
    		<button type="submit" class="btn btn-primary">Save Student</button>
 		 </div>
		
	</form>
    </div>
    
     <nav class="fixed-bottom ms-3" style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="StudentInfo">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Add Student</li>
		  </ol>
	</nav>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>