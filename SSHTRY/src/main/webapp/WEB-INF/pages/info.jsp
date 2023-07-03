<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>i am info.jsp</h1>

	<p>
		帳號:<s:property value="name" /><br />
		密碼:<s:property value="password" />
	</p>
	
</body>
</html>