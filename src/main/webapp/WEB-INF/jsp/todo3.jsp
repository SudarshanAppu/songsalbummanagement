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
	<h1>selected song details are : </h1> ${todo2songs}
	<h2> Please enter the details to update the song</h2>
 <div class="container">
		<form method="post">
	    id        : <input type="number" name="id" required="required">		
		song title: <input type="text" name="songsTitle" required="required">
		child fav : <input type="text" name="childfav" required="required">
		artist    : <input type="text" name="artist" required="required">
		datetime  : <input type="Date" name="dateTime" required="required">
		duration  : <input type="number" name="duration" required="required">
			

			<button type="submit" class="btn btn-success">update</button>
			</form>
	</div>
 

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>