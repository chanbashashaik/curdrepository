<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contactinfo</title>

<link href="../style/contactinfo.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="container">
	<p><h1><center>${msg}</center></h1></p>
	<p><font color='green'>${sussMsg}</font></p>
	<p ><font color='red'>${errMsg }</font></p>
	
	<form:form action="addcontact" modelAttribute="contact" method="POST" name="contactinfo">

		<table>
			<tr><td ><form:hidden path="contact_id"/></td></tr>
			<tr><td ><form:hidden path="delete_switch" /></td></tr>
			<tr>
			
				<td>UserName:</td>
				<td><form:input path="contact_name" /></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><form:input path="contact_email"  /></td>
			</tr>
			<tr>
				<td>Number:</td>
				<td><form:input path="contact_number" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="reset" /></td>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
		

	</form:form>
	</div>
	<div class="container">
	<a href="viewcontacts">ViewAllContacts</a>
</div>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/phbook.js"></script>


</body>
</html>