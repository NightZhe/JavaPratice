<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>請輸入你的帳號，以便找回密碼</h3>
	<br />
	<form action="RetrievePassword" method="post">
		<label>帳號</label> 
		<input type="text" name="userName"><br /><br />

		<button type="submit" name="submit">送出</button>
	</form>

</body>
</html>