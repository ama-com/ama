<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.ProductList">
    <@ taglib prefix="c" url="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ama.com|Order</title>
    <link rel="stylesheet" href="style.css">
</head>
	<body>
		<header>
        	<nav>
            	<ul>
                	<li>
                    	<a href="index.html"><img class="icon" src="images/icon.png" alt=""></a>
                	</li>
                	<li>
                    	<form action="#" class="search-form-6">
                        	<label>
                            	<input type="text" aria-label="キーワードを入力">
                        	</label>
                    	</form>
                	</li>
                	<li>
                		<a href="Authentication" class="btn btn--orange btn--cubic btn--shadow">ログイン</a>
                	</li>
                	<li>
                		<a href="AccountRegistration" class="btn btn--orange btn--cubic btn--shadow">会員登録</a>
                	</li>
					<li>
						<a href = "/ama/test.html">test</a>
					</li>
            	</ul>
        	</nav>

    	</header>
		<main>
			<h1 class="cart">購入画面</h1>
			<p>
				<c:out value="${Account.name}"></c:out>さんログイン中
			</p>
			<div class="item">
			<p>購入商品</p>
			<c:if test="${not empty errorMsg}">
				<p>
					<c:out value="${errerMsg}"></c:out>
               	</p>
           	</c:if>
           	<c:forEach var="product" items="${ProductList}">  
           	<p>
           		<c:out value="${product.name}" />
          	</p>
         	</c:forEach>
			</div>  
  		</main>
	</body>
</html>