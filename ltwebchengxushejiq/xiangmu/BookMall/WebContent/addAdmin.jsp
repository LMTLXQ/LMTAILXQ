<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
.container {
	width: 300px;
}
</style>
</head>
<body>
	<div class="container">
			<form class="form-signin" action="AddAdminServlet">
				<h2 class="form-signin-heading">添加管理员：</h2>
				<label for="inputEmail" class="sr-only">用户名</label>
				<input type="text" name="aname" class="form-control" placeholder="用户名" required autofocus><br>
				<label for="inputPassword" class="sr-only">密码</label>
				<input type="password" name="apwd" class="form-control" placeholder="密码" required><br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
				<input class="btn btn-lg btn-primary btn-block" type=button value="返回登录" onclick="window.location.assign('index.jsp')">
			</form>
			<%
				Cookie[] cookies = request.getCookies();
				if(cookies!=null){
					for(Cookie cookie:cookies){
						if(cookie.getName().equals("add")){
							out.print(cookie.getValue());
						}
					}
				}
			%>
		</div> 
</body>
</html>