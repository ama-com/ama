<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
    <c:forEach var="product" items="${productList}">
        <div>
            <p><c:out value="${product.name}" /></p>
            <img src="<c:out value="${product.imagePath}" />" alt="<c:out value="${product.name}" />のイメージ画像" />
            <p><c:out value="${product.price}" /></p>
            <p><c:out value="${product.stock}" /></p>
        </div>
    </c:forEach>
</body>
</html>
