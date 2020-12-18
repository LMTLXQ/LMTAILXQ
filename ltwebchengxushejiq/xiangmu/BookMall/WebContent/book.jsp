<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.book.entity.Page"%>
<%@page import="org.book.entity.Book"%>
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
		<h3 class="panel-title">图书管理</h3>
	</div>
	<div class="panel-body form">
		<table class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<td colspan="7">
					<form class="bs-example bs-example-form" role="form" action="FuzzyQueryBook">
		                <div class="input-group">
		                    <input type="text" class="form-control" name="bname">
		                    <span class="input-group-btn">
		                        <button class="btn btn-default" type="submit">搜索</button>
		                    </span>
		                </div>
					</form>
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<th>图片</th>
				<th>书名</th>
				<th>价格</th>
				<th>类别</th>
				<th>简介</th>
				<th>操作</th>
			</tr>
			<%
				Page p = (Page) request.getAttribute("p");

				for (Book book : p.getBooks()) {
					String path = book.getBookImage();
					String path1 = path.substring(23);

					//out.print(path1);
			%>
			<tr class="form-group">
				<td><%=book.getBookID()%></td>
				<td><img src="<%=path1%>" whidt="20px" height="40px"></td>
				<td><%=book.getBookName()%></td>
				<td><%=book.getBookPrice()%></td>
				<td><%=book.getBookCategory()%></td>
				<td><textarea class="for-control" cols="25" readonly><%=book.getBookIntroduction()%></textarea></td>
				<td class="td1">
					<div class="btn-group btn-group-sm">
						<a href="updateBook.jsp?bid=<%=book.getBookID()%>"><button
								type="button" class="btn btn-default">修改</button></a> <a
							href="DeleteBookServlet?bid=<%=book.getBookID()%>"><button
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
			<a href="QueryAllBookServlet?currentPage=1"><button type="button"
					class="btn btn-default">首页</button></a> <a
				href="QueryAllBookServlet?currentPage=<%=p.getCurrentPage() - 1%>"><button
					type="button" class="btn btn-default">上一页</button></a> <a href="#"><button
					type="button" class="btn btn-default">下一页</button></a> <a href="#"><button
					type="button" class="btn btn-default">尾页</button></a> <a
				href="addBook.jsp"><button type="button" class="btn btn-default">新增</button></a>
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
			<a href="QueryAllBookServlet?currentPage=<%=p.getCurrentPage() + 1%> "><button
					type="button" class="btn btn-default">下一页</button></a> <a
				href="QueryAllBookServlet?currentPage=<%=p.getTotalPage()%>"><button
					type="button" class="btn btn-default">尾页</button></a> <a
				href="addBook.jsp"><button type="button" class="btn btn-default">新增</button></a>
		</div>
	</div>
	<%
		} else {//中间
	%>
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group">
			<a href="QueryAllBookServlet?currentPage=1"><button type="button"
					class="btn btn-default">首页</button></a> <a
				href="QueryAllBookServlet?currentPage=<%=p.getCurrentPage() - 1%>"><button
					type="button" class="btn btn-default">上一页</button></a> <a
				href="QueryAllBookServlet?currentPage=<%=p.getCurrentPage() + 1%> "><button
					type="button" class="btn btn-default">下一页</button></a> <a
				href="QueryAllBookServlet?currentPage=<%=p.getTotalPage()%>"><button
					type="button" class="btn btn-default">尾页</button></a> <a
				href="addBook.jsp"><button type="button" class="btn btn-default">新增</button></a>
		</div>
	</div>

	<%
		}
	%>
	</div>
</div>
</body>
</html>