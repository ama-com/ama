<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
	<c:forEach var="Product" items="${ProductList}">
		<div>
			<p><c:out value="Product.name" /></p>
			<img src="<c:out value="Product.imagePass />" alt="<c:out value="Product.name" />のイメージ画像" />
			<p><c:out value="Product.price" /></p>
			<p><c:out value="Product.stock" /></p>
		</div>
	</c:forEach>
</body>
</html>