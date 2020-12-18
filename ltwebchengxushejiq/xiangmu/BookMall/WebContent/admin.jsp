<%@page import="org.book.entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.book.entity.Page"%>
<%@page import="org.book.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	padding: 0;
	margin: 0;
}

h1 {
	text-align: center;
}

nav {
	font-size: 25px;
	width: 300px;
	margin-left: 20px;
}

nav ul {
	border: 1px solid #ADADAD;
	border-radius: 10px;
	padding-left: 0;
}

nav li {
	list-style: none;
	border-bottom: 1px solid #ADADAD;
	padding: 5px 10px;
}

a {
	text-decoration: none;
	margin: 0;
	padding: 0;
}

body .btn-toolbar {
	padding-left: 30%;
	margin: 10px;
}

.div1 {
	width: 900px;
	margin-left: 100px;
}

.panel-body {
	height: 350px;
}

table td {
	text-align: center;
	height: 50px;
}

table th {
	text-align: center;
	height: 50px;
}

.td1 {
	width: 200px;
}

h3 {
	margin-left: 20px;
	font-family: "宋体";
}

h3 i {
	color: red;
}
</style>
<script type="text/javascript" src="js/donghua.js"></script>
</head>
<body>
<h1>书城管理系统</h1>
<%
	HttpSession session1 = request.getSession();
	String name = (String) session1.getAttribute("name");
	if (name == null) {
		name = "未登录";
	}
%>
<div class="row">
	<h3 class="col-sm-3">
		当前管理员：<i><%=name%></i>
	</h3>
	<div class="col-sm-6"></div>
	<div class="btn-group btn-group-lg  col-sm-2">
		<a href="index.jsp"><button type="button" class="btn btn-default">退出</button></a>
	</div>
	<div class="col-sm-1"></div>
</div>
<div class="row">
	<div class="col-sm-2">
		<nav>
		<ul>
			<li><a href="home.jsp">首页</a><br /></li>
			<li><a href="QueryAllUserServlet">用户管理</a></li>
			<li><a href="QueryAllAdminServlet">管理员管理</a><br /></li>
			<li><a href="QueryAllBookServlet">图书管理</a><br /></li>
		</ul>
		</nav>
		<div id="div2" style="height:100px;width:500px;position:absolute;color:green; ">欢迎您!<%=name%></div>
	</div>
	
	<div class="div1 panel panel-primary col-sm-8">
		<div class="panel-heading">
			<h3 class="panel-title">管理员管理</h3>
		</div>
		<div class="panel-body">
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>密码</th>
					<th>操作</th>
				</tr>
				<%
					Page p = (Page) request.getAttribute("p");

					for (Admin admin : p.getAdmins()) {
				%>
				<tr>
					<td><%=admin.getAid()%></td>
					<td><%=admin.getAname()%></td>
					<td><%=admin.getApwd()%></td>
					<td class="td1">
						<div class="btn-group btn-group-sm">
							<a href="updateAdmin.jsp?aid=<%=admin.getAid()%>"><button
									type="button" class="btn btn-default">修改</button></a> <a
								href="DeleteAdminServlet?aid=<%=admin.getAid()%>"><button
									type="button" class="btn btn-default">删除</button></a>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<%
			if (p.getCurrentPage() == p.getTotalPage()) { //尾页
		%>
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group">
				<a href="QueryAllAdminServlet?currentPage=1"><button
						type="button" class="btn btn-default">首页</button></a> <a
					href="QueryAllAdminServlet?currentPage=<%=p.getCurrentPage()%>"><button
						type="button" class="btn btn-default">上一页</button></a>
				</button>
				<a href="#"><button type="button" class="btn btn-default">下一页</button></a>
				<a href="#"><button type="button" class="btn btn-default">尾页</button></a>
				<a href="addAdmin.jsp"><button type="button"
						class="btn btn-default">新增</button></a>
			</div>
		</div>
		<%
			}

			else if (p.getCurrentPage() == 1) {//首页
		%>
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group">
				<a href="#"><button type="button" class="btn btn-default">首页</button></a>
				<a href="#"><button type="button" class="btn btn-default">上一页</button></a>
				<a
					href="QueryAllAdminServlet?currentPage=<%=p.getCurrentPage() + 1%> "><button
						type="button" class="btn btn-default">下一页</button></a> <a
					href="QueryAllAdminServlet?currentPage=<%=p.getTotalPage()%>"><button
						type="button" class="btn btn-default">尾页</button></a> <a
					href="addAdmin.jsp"><button type="button"
						class="btn btn-default">新增</button></a>
			</div>
		</div>
		<%
			} else {//中间
		%>
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group">
				<a href="QueryAllAdminServlet?currentPage=1"><button
						type="button" class="btn btn-default">首页</button></a> <a
					href="QueryAllAdminServlet?currentPage=<%=p.getCurrentPage() - 1%>"><button
						type="button" class="btn btn-default">上一页</button></a> <a
					href="QueryAllAdminServlet?currentPage=<%=p.getCurrentPage() + 1%> "><button
						type="button" class="btn btn-default">下一页</button></a> <a
					href="QueryAllAdminServlet?currentPage=<%=p.getTotalPage()%>"><button
						type="button" class="btn btn-default">尾页</button></a> <a
					href="addAdmin.jsp"><button type="button"
						class="btn btn-default">新增</button></a>
			</div>
		</div>

		<%
			}
		%>
	</div>
</div>
</body>
</html>