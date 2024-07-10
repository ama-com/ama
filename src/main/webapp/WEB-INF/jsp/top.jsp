<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ama.com|TOP</title>
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
                <li><a href="Authentication" class="btn btn--orange btn--cubic btn--shadow">ログイン</a></li>
                <li><a href="AccountRegistration" class="btn btn--orange btn--cubic btn--shadow">会員登録</a></li>
				<li><a href = "/ama/test.html">test</a></li>
            </ul>
        </nav>

    </header>
    
    <main>
    <c:forEach var="product" items="${productList}">
        <div>
            <p><c:out value="${product.name}" /></p>
            <img src="<c:out value="${product.imagePath}" />" alt="<c:out value="${product.name}" />のイメージ画像" />
            <p><c:out value="${product.price}" /></p>
            <p><c:out value="${product.stock}" /></p>
        </div>
    </c:forEach>
    </main>
</body>
</html>
