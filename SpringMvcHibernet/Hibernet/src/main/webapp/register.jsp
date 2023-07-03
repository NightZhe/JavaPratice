<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 4 MVC - HelloWorld Index Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<h2>註冊頁面</h2>

	<form action="register" method="post">
		<label>帳號</label> <input type="text" name="name" id="name" required><br />
		<br /> <label>密碼</label> <input type="text" name="password" id=password ><br />
		<br /> <label>信箱</label> <input type="text" name="email" id= email><br />
		<br />
		<button type="submit" class="register-submit">註冊</button>
	</form>
${message}
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
					success:function(reponse){
							if((reponse.message) == "repeat"){
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
