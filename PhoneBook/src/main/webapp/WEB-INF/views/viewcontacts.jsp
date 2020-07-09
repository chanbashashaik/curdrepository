<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewcontacts</title>

	
	<script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="../js/jquery.datatables.min.js"></script>
	<script type="text/javascript" src="../js/phbook.js"></script>
	<link href="../style/jquery.datatables.min.css" rel="stylesheet" type="text/css">
	<link href="../style/contactinfo.css" rel="stylesheet" type="text/css">
</head>
<body>
<p>
<font color="blue"><h1><center>view all contacts</center></h1></font></p>
<p>
<font color="red"><h5><center>${deletemsg}</center></h5></font>
</p>
<p>	<a href="index">+AddContact</a></p>

	<table id="example" border=1>
		<thead>
			<tr>
				<th>S.NO</th>
				<th>Name</th>
				<th>E-Mail</th>
				<th>Ph.No</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts }" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contact_name}</td>
					<td>${c.contact_email}</td>
					<td>${c.contact_number}</td>
					<td><a href="editcontact?cid=${c.contact_id }">Edit</a> 
					<a href="deletecontact?cid=${c.contact_id}"  onclick="return deleteConfirm()">Delete</a>
					</td>
				</tr>



			</c:forEach>

		</tbody>

	</table>
	
	
</body>
</html>