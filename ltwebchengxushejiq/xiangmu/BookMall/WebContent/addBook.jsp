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
	<!-- <form action="UploadBookServlet" method="post" enctype="multipart/form-data">
		书名：<input name="bname">
		价格：<input name="price">
		种类：<input name="category">
		简介：<input type="textarea" name="introduction">
		图片：<input type="file" name="image">
		<input type="submit" value="上传">
	</form> -->
	<div class="container">
			<form class="form-signin" action="UploadBookServlet" method="post" enctype="multipart/form-data">
				<h2 class="form-signin-heading">新增书籍：</h2>
				<label for="inputEmail" class="sr-only">书名:</label>
				<input type="text" name="bname" class="form-control" placeholder="书名" required autofocus><br>
				
				<label for="inputPassword" class="sr-only">价格</label>
				<input type="text" name="price" class="form-control" placeholder="价格" required><br>
				
				<div>
					<label class="radio-inline">
						<input type="radio" name="category" value="文学"  checked> 文学
					</label>
					<label class="radio-inline">
						<input type="radio" name="category" value="社科" > 社科
					</label>
					<label class="radio-inline">
						<input type="radio" name="category" value="经营" > 经管
					</label>
					<label class="radio-inline">
						<input type="radio" name="category" value="生活" > 生活
					</label>
				</div>
				<br>
				
				<label for="inputPassword" class="sr-only">简介</label>
				<input type="text" name="introduction" class="form-control" placeholder="简介" required><br>
				
				<label for="file" class="sr-only">图片</label>
				<input type="file" name="image" class="form-control" placeholder="图片" required><br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">新增</button>
			</form>
		</div> 
</body>
</html>