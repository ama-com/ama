<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/ama/Product" enctype="multipart/form-data">
		<div>
			<label for="name">商品名</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label for="explanation">説明</label>
			<input type="text" name="explanation" />
		</div>
		<div>
			<label for="price">値段</label>
			<input type="text" name="price" />
		</div>
		<div>
			<label for="stock">在庫</label>
			<input type="text" name="stock" />
		</div>
			<label for="image">画像</label>
			<input type="file" name="image"/>
		<div>
			<input type="submit" value="登録する">
		</div>
	</form>
</body>
</html>