<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
.container {
	width: 300px;
}
</style>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
 <script type="text/javascript">
     //刷新验证码
     function changeImg(){
         document.getElementById("validateCodeImg").src="CheckCodeServlet?"+Math.random();
     }
</script>


</head>
<body>
	<div class="container">
		<form class="form-signin" action="AdminLoginServlet">
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputEmail" class="sr-only">用户名</label> 
			<input type="text" name="aname" id="username" class="form-control required" placeholder="用户名" required autofocus><br>
			<span id="user" style="color:red;"></span>
			<label for="inputPassword" class="sr-only">密码</label> 
			<input type="password" name="apwd" id="password" class="form-control required" placeholder="密码" required><br>
			<span id="pwd" style="color:red;"></span>
			<label for="inputEmail" class="sr-only">验证码</label> 
			<input type="text"  name="validateCode" class="form-control" placeholder="验证码" required autofocus> <br>
             <img alt="验证码看不清，换一张" src="CheckCodeServlet" id="validateCodeImg" onclick="changeImg()">
             <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">记住账号
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			<input class="btn btn-lg btn-primary btn-block" type=button value="注册" onclick="window.location.assign('addAdmin.jsp')">
			<%
				Cookie[] cookies = request.getCookies();
				if(cookies!=null){
					for(Cookie cookie:cookies){
						if(cookie.getName().equals("login")){
							out.print(cookie.getValue());
						}
					}
				}
			%>
		</form>
	</div>
</body>
</html>
<script type="text/javascript" src="js/form.js"></script>