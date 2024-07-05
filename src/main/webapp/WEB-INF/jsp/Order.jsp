<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="model.ProductList">
        <@ taglib prefix="c" url="jakarta.tags.core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Order</title>
            </head>

            <body>
                <h1>購入画面</h1>
                <p>
                    <c:out value="${Account.name}"></c:out>さんログイン中
                </p>

                <p>購入商品</p>
                <c:if test="${not empty errorMsg}">
                    <p>
                        <c:out value="${errerMsg}"></c:out>
                    </p>
                </c:if>
                <c:forEach var="product" items="${ProductList}">
                    <div>
                        <p>
                            <c:out value="${product.name}" />
                        </p>
                    </div>
                </c:forEach>
            </body>

            </html>