<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
					
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Languages</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5 p-3">
		<h1 class="text-center p-3">Languages</h1>
		<table class="table table-striped">
	    	<thead>
	        	<tr>
	            	<th>Name</th>
	            	<th>Creator</th>
	            	<th>Version</th>
	            	<th>Actions</th>
	        	</tr>
	    	</thead>
	    	<tbody>
	        	<c:forEach items="${languages}" var="lang">
	        	<tr>
	            	<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
	            	<td><c:out value="${lang.creator}"/></td>
	            	<td><c:out value="${lang.version}"/></td>
	            	<td>
	            		<a href="/languages/edit/${lang.id}">Edit</a>
		            	<a class="m-3" href="/languages/delete/${lang.id}">Delete</a>            	
	            	</td>
	        	</tr>
	        	</c:forEach>
	    	</tbody>
		</table>
		<div class="main form-group row border border-dark mt-5 bg-light">
			<form:form action="/languages" method="post" modelAttribute="language">
	    		<p class="m-3">
	        		<form:label  class="col-sm-2 col-form-label" path="name">Name</form:label>
	        		<form:errors path="name"/>
	        		<form:input class="form-control" path="name"/>
	    		</p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="creator">Creator</form:label>
			        <form:errors path="creator"/>
			        <form:textarea class="form-control" path="creator"/>
			    </p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="version">Version</form:label>
			        <form:errors path="version"/>
			        <form:input class="form-control" path="version"/>
			    </p>  
				<input type="submit" value="Submit" class="m-3"/>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>