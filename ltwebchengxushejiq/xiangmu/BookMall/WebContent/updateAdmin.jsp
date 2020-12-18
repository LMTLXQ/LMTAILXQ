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
	<%-- <form action="UpdateAdminServlet">
	<%
		String id = (String)request.getParameter("aid");
	%>
		ID:<input name="aid" value=<%=id %> readonly>
		用户名：<input name="aname">
		密码：<input name ="apwd"> 
		<input type="submit" value="修改">
	</form> --%>
	
	<div class="container">
	<%
		String id = (String)request.getParameter("aid");
	%>
			<form class="form-signin" action="UpdateAdminServlet">
				<h2 class="form-signin-heading">修改管理员信息：</h2>
				<label for="inputtext" class="sr-only">ID:</label>
				<input type="text" name="aid" value="<%=id %>" class="form-control" placeholder="ID" required autofocus readonly><br>
				<label for="inputText" class="sr-only">用户名</label>
				<input type="text" name="aname" class="form-control" placeholder="用户名" required autofocus><br>
				<label for="inputPassword" class="sr-only">密码</label>
				<input type="password" name="apwd" class="form-control" placeholder="密码" required><br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
			</form>
		</div> 
</body>
</html>