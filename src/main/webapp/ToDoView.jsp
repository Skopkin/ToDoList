<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#deleteItem").hide();
     $("#updateItem").hide();
    
    $("#update").click(function(){
        $("#updateItem").show();
        $("#deleteItem").hide();
    });
    $("#delete").click(function(){
        $("#deleteItem").show();
         $("#updateItem").hide();
    });
});
</script>
</head>
<body>
	All To-Do Items:
	<br>
	<c:forEach var="td" items="${ToDoList}">
			ID: ${td.id} <br>
            Task: ${td.task} <br>
            -------------------------------------<br>
	</c:forEach>
	<form action="ToDoController" method="POST">
		Update: <input type="checkbox" id="update"> Delete: <input
			type="checkbox" id="delete"
			onclick="document.getElementById('uTask').disabled=this.checked;"><br>
		<br> <select id="taskSelect" name="taskSelect">
			<c:forEach var="td" items="${ToDoList}">
				<option value="${td.id}">${td.id}: ${td.task}</option>
			</c:forEach>
		</select> <br> Update Task: <input id="uTask" type="text" name="uTask"><br>
		<button type="submit" id="updateItem" name="updateItem">
			Update</button>
		<br> <br>
		<button type="submit" id="deleteItem" name="deleteItem">
			Delete</button>
	</form>
</body>
</html>