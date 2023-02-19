<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html:charset=UTF-8" %>

<html>
<head>
<title>入力内容不適合</title>
</head>
<body>

<h1>例外のメッセージ:${pageContext.exception.message}</h1>
<h1>例外のタイプ:${pageContext.exception.class.name}</h1>

<a href="inputtop">入力内容が不適切です。入力し直してください。</a>

<p><font color="#FFFFFF">
	テストテストテスト
</font></p>
</body>
</html>