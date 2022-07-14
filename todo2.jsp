<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> addd song</h1>
	
	<div class="container">
		<form method="post" >
	    id        : <input type="number" name="id" required="required">		
		song title: <input type="text" name="songtitle" required="required">
		child fav : <input type="text" name="childfav" required="required">
		artist    : <input type="text" name="artist" required="required">
		datetime  : <input type="text" name="datetime" required="required">
		duration  : <input type="number" name="duration" required="required">
			

			<button type="submit" class="btn btn-success">Add</button>
			</form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>