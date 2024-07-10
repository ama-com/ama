<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ama.com|ProductForm</title>
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
                <li><a href="AccountRegistration" class="btn btn--orange btn--cubic btn--shadow">会員登録</i></a></li>
				<li><a href = "/ama/test.html">test</a></li>
            </ul>
        </nav>

    </header>
    
<body>
<div class="syosai">
	<form method="POST" action="/ama/ProductCreate" enctype="multipart/form-data">
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
		<div class="button">
			<input type="submit" value="登録する">
		</div>
	</form>
</div>
</body>
</html>