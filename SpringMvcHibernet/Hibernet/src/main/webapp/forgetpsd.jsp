<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js">
</script>
</head>
<body>
	<h3>請輸入你的帳號，以便找回密碼</h3>
	<br />
	<form action="forgetpassword" method="post">
		<label>帳號</label> 
		<input type="text" name="name" id="name"><br /><br />

		<button type="submit" name="submit" id="comfirm">送出</button>
	</form>
	${message}
	


</body>
</html>