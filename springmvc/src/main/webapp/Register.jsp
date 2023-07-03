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

	<form action="Register" method="post">
		<label>帳號</label> <input type="text" name="UserName" id="UserName"><br />
		<br /> <label>密碼</label> <input type="text" name="UserPassword" id=UserPassword ><br />
		<br /> <label>信箱</label> <input type="text" name="UserEmail" id= UserEmail><br />
		<br />
		<button type="button" class="register-submit">送出</button>
		<button type="submit" class="register-submit2">註冊</button>
	</form>
	
	<form action ="fgps.jsp">
		<button type="submit" class="forgetPassword">忘記密碼</button>
		</form>

	<script type="text/javascript">
		var data = {};
		$(function() {
			$('.register-submit2').on('click', function() {
				var username = $("#UserName").val();
				data = {
					username : username
				};
				$.ajax({
					type : 'get',
					url : "./comfirm?UserName=" + username,
					success : function(result) {
						console.log(result);
						if (result == "repeat") {
							alert("重複了請重新輸入");
						} else {
							alert("沒有重複")
						}
					}
				});
			});
		});
		$(function() {
			  $('.register-submit2').on('click', function() {
			    var email = $('#UserEmail').val();
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
