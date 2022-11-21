<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Simple Login Page</title>
	</head>
	<body>
		<form method="post" action="LoginVerify">
		<!-- Servlet LoginVerify que vous allez faire -->
			<table>
				<tr>
					<td>Login</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>Pwd</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="login"></td>
				</tr>
			</table>
		</form>
	</body>
</html>