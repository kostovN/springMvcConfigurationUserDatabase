<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>ID</td>
				<td>Username</td>
				<td>Name</td>
				<td>Surname</td>

			</tr>

			<tr>
				<td>${applicationScope.user.id}</td>
				<td>${applicationScope.user.username}</td>
				<td>${applicationScope.user.firstname}</td>
				<td>${applicationScope.user.lastname}</td>

			</tr>

			<tr>
				<td><a href="../back">Back</a></td>
			</tr>
		</table>
	</form>
</body>
</html>