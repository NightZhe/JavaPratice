<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
#wrapper {
	width: 800px;
	margin: 0 auto;
}
</style>

	<h1>登入頁面</h1>
	<form action="login" method="get">
		<label>使用者帳號</label> <input type="text" name=userName><br />
		<label>密碼</label> <input type="text" name=userpassword>
		<button type="submit">登入</button>
	</form>
	<button type="submit" name="register"><a href="Register.jsp">註冊</a></button>

	<button type="button">忘記密碼</button>


	





</body>
</html>