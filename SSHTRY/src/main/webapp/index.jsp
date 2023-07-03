<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>
<body onload="load()">

	<h1>首頁，登入頁面</h1>
	<form action="login">
		<input type="hidden" id="id" value="0"> <label>帳號</label> <input
			type="text" name="name" id="name"><br /> <label>密碼</label> <input
			type="text" name="password" id="password"><br />
		<button type="submit" id="submit">登入</button>
	</form>
	
	<button type="submit" name="register"
		onclick="window.location.href='register'">
		註冊
		<!-- <a href="register.jsp">註冊</a> -->
	</button>
	<button type="submit" name="forgetPassowrd"
		onclick="window.location.href='forgetPassowrd'">忘記密碼</button>


	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>

	<!-- 		 <button type="button" onclick="add()" name=add id="add">Add</button> -->
	<!-- 	<button type="button" name=add id="add">Add/Edit</button> -->

	<!-- 	<table id="table" border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Passowrd</th>
			<th>Email</th>
			<th>Edit</th>
			<th>delete</th>
		</tr>
	</table>
 -->
	<script type="text/javascript">
		function load() {
			$
					.ajax({
						url : 'list',
						type : 'POST',
						success : function(response) {
							data = response.data;
							$('.tr').remove();
							for (i = 0; i < response.data.length; i++) {
								$("#table")
										.append(
												"<tr class='tr'> <td> "
														+ response.data[i].id
														+ " </td><td> "
														+ response.data[i].name
														+ " </td> <td> "
														+ response.data[i].password
														+ " </td><td> "
														+ response.data[i].email
														+ " </td> <td> <a href='#' onclick= edit("
														+ i
														+ ");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("
														+ response.data[i].id
														+ ");'> Delete </a>  </td> </tr>");
							}
						}
					});

		}
		$(function() {
			$("#add").on("click", function() {
				$.ajax({
					url : "saveOrUpdate",
					type : "POST",
					// id 不能為unll 不然會送出不過去，所以要在上面id 那邊補個0
					data : {
						id : $('#id').val(),
						name : $('#name').val(),
						password : $("#password").val()
					},
					success : function(response) {
						alert("success");
						load();
						//跳轉到指定頁面可以參數
						// 					window.location.href = "/Hibernet/users/login?name="+$('#name').val()+"&password="+$("#password").val();
					},
					error : function() {
						console.log("UnSuccess");
					}
				});
			});

		});

		edit = function(index) {
			$("#id").val(data[index].id);
			$("#name").val(data[index].name);
			$("#password").val(data[index].password);
			// 			$("#email").val(data[index].email);

		}

		///delete 這個地方一定要加入底線

		delete_ = function(id) {
			$.ajax({
				url : 'delete',
				type : 'POST',
				data : {
					id : id
				},
				success : function(response) {
					alert(response.message);
					load();
				}
			});
		}

		// 	data = "";
		// 	add = function(){

		// 			$.ajax({
		// 				url:'users/saveOrUpdate',
		// 				type:'POST',
		// 				data:{id:$("#id").val(),name:$('#name').val(),password:$('#password').val()},
		// 				success: function(response){
		// 						alert(response.message);

		// 				}				
		// 			});			
		// 	}
	</script>



</body>
</html>