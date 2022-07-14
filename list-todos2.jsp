<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Todo's for :${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your songs are</caption>
			<thead>
				<tr>
				    <th>id</th>
					<th>songtitle</th>
					<th>child fav</th>
				    <th>artist</th>
				    <th>datetime</th>
				     <th>duration</th>
				     <th>delete</th>
				     <th>update</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
					    <td>${todo.id}</td>
						<td>${todo.songsTitle}</td>
						<td>${todo.childfav}</td>
						<td>${todo.artist}</td>
						<td>${todo.dateTime}</td>
						<td>${todo.duration}</td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-waring"> Delete</a>  </td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-success"> Update</a>  </td>
                      
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
		<div> <a class="button" href="/add-todo">Add a song</a></div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</html>