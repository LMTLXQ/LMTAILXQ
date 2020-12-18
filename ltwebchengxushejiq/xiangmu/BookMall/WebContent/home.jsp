<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<link href="css/lunbo.css">
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

li a {
	text-decoration: none;
}

.div1 {
	padding: 30px;
	font-family: "宋体";
	font-size: 30px;
}

h3 {
	margin-left: 20px;
	font-family: "宋体";
}

h3 i {
	color: red;
}


.container {
			position: absolute;
			top: 0;
			left: 100px;
			width: 1000px;
			height: 500px;
		}
		/*使用绝对定位，使全部图片叠加到一块*/
		
		.box,
		.box img {
			position: absolute;
			top: 0;
			left: 0;
		}
		/*下面小圆点，使用绝对定位，位于图片的正下方*/
		
		.circle {
			width: 200px;
			height: 14px;
			position: absolute;
			bottom: 15px;
			left: 50%;
			margin-left: -100px;
			text-align: center;
			cursor: pointer;
		}
		/*每个小圆点的样式*/
		
		.circle b {
			display: inline-block;
			width: 14px;
			height: 14px;
			background-color: #000;
			border-radius: 50%;
			margin: 3px;
		}
		/*小圆点的当前样式，也是鼠标移上去的样式*/
		
		.circle .current {
			background-color: #fff;
		}
		/*左右两侧的按钮，采用绝对定位*/
		
		.btn1 {
			position: absolute;
			top: 50%;
			width: 40px;
			height: 50px;
			margin-top: -25px;
			background-color: rgba(255, 255, 255, .7);
			text-align: center;
			line-height: 50px;
			font-size: 50px;
			cursor: pointer;
		}
		
		.left {
			left: 0;
		}
		
		.right {
			right: 0;
		}
</style>
<script type="text/javascript" src="js/donghua.js"></script>
<script type="text/javascript">
	var i = 0;
    var timer;
    $(function(){
        $("img").eq(0).show().siblings().hide();
        start();
        $("b").hover(function(){
            clearInterval(timer);
            i = $(this).index();
            change();
        }, function(){
            start();
        });
        $(".left").click(function(){
            i--;
            if(i == -1){
                i = 5;
            }
            change();
        });
        $(".right").click(function(){
            i++;
            if(i == 6){
                i = 0;
            }
            change();
        });
    });
    function start(){
        timer = setInterval(function(){
            i++;
            if(i == 6){
                i = 0;
            }
            change();
        }, 3000);
    }
    function change(){
        $("img").eq(i).fadeIn(300).siblings().stop(true, true).fadeOut(300);
        $("b").eq(i).addClass("current").siblings().removeClass("current");
    }
</script>

</head>
<body>
<head>
<%
	HttpSession session1 = request.getSession();
	String name = (String) session1.getAttribute("name");
	if (name == null) {
		name = "未登录";
	}
%>

<h1>书城管理系统</h1>
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
</head>
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
	<div class="col-sm-10">
			
			<div>
				<div class="container">
					<div class="box">
						<img src="img/1.jpg">
						<img src="img/2.jpg">
						<img src="img/3.jpg">
						<img src="img/4.jpg">
						<img src="img/5.jpg">
						<img src="img/6.jpg">
					</div>
					<div class="circle">
						<b class="current"></b>
						<b></b>
						<b></b>
						<b></b>
						<b></b>
						<b></b>
					</div>
					<div class="btn1 left"> &lt; </div>
					<div class="btn1 right"> &gt; </div>
				</div>
			</div>
	</div>
</div>
</body>
</html>