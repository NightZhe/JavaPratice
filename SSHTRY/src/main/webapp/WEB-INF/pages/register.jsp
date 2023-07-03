<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>這是註冊頁面</title>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>

<body>
<h1>註冊帳號密碼</h1>
	<form action ="saveuser" >
		<label>帳號</label>
		<input type="text" name="name" id="name"><br />
		<label>密碼</label>
		<input type="text" name="password" id="password"><br />
		<label>信箱</label>
		<input type="text" name="email" id="email"><br />
		<button type="submit" name="register" id="register">註冊</button>
	</form>

	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>
	
	
	<script type="text/javascript">
	$(function () {
		$('#name').on('blur',function(){
			let userName ="";
			userName =$('#name').val();
			console.log(userName);
			if(userName == ''){
				alert("請輸入帳號");
				event.preventDefault()
			}else{
				$.ajax({
					url:"comfirm",
					type:'post',
					data:{name:$('#name').val()},
					success:function(data){
							if(data.message == "repeat"){
								alert("帳號重複了，請重新輸入")
								event.preventDefault();	
							}else{
								alert("帳號可以使用")
							}
					},
					error:function(){
						alert("error message");
						}
					});
			}
		
		});
	})	
	
		$(function() {
			  $('#email').on('blur', function() {
			    var email = $('#email').val();
			    if (isValidEmail(email)) {
			      alert("邮箱格式正确！");  
			    } else {
			      alert("邮箱格式不正确！");
			      event.preventDefault(); // 阻止提交表單
			    }
			  });
			});

			function isValidEmail(email) {
			  // 正则表达式验证邮箱格式
			  var reg = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
			  return reg.test(email);
			}
			

	</script>


</body>
</html>