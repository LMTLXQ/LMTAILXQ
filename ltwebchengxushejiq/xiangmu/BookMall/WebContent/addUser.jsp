<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Signin Template for Bootstrap</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
	.container{
		width: 300px;
	}
</style>
</head>
<body>
	<div class="container">
			<form class="form-signin" action="AddUserServlet">
				<h2 class="form-signin-heading">新增用户：</h2>
				<label for="inputEmail" class="sr-only">用户名</label>
				<input type="text" name="uname" class="form-control" placeholder="用户名" required autofocus><br>
				<label for="inputPassword" class="sr-only">密码</label>
				<input type="password" name="upwd" class="form-control" placeholder="密码" required><br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
			</form>
		</div> 
</body>
</html>