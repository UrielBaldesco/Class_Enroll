<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Display Groups</title>
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
    <h2 class="text-center display-4 mb-3">Groups</h2>
    <div class="container">
    	<table class="table table-bordered border-primary">
			<c:forEach items="${groups}" var="group">
				<tr>
					<td><h6>${group.groupName}</h6></td>
					<td><a class="btn btn-outline-primary" href="EditGroup?id=${group.idGroup}" role="button">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
    </div>
    <nav class="fixed-bottom ms-3" style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="StudentInfo">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Groups</li>
		  </ol>
	</nav>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>
