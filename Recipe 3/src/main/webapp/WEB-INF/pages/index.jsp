<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Recipe 3 (Spring Cache Abstraction)</title>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/application.js'/>"></script>

</head>
<body>
	<h1>Recipe 3 (Spring Cache Abstraction with EhCache)</h1>
	
	<div style="margin-bottom:15px;">
		<input type="button" id="load-list-btn" value="Load Employees From Database"/>
	</div>
	
	<table id="employees-table" width="600" border="1" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department</th>
				<th>Role</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
</body>
</html>