<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>ページが見つかりません</title>
</head>
<body>
<h1> Web ページが見つかりません　 (; ･`д･´) </h1>

<p>可能性のある原因: </p>
<ul>
<li>アドレスに入力ミスがある。</li>
<li>リンクをクリックした場合には、リンクが古い場合があります。</li>
</ul>
<br>

<p>対処方法: </p>
<ul>
 <li> アドレスを再入力する。</li>
<li><a href="inputtop">トップページに戻ります。</a></li>
</ul>
<p><font color="#000">
	すみません
</font></p>

<h6>例外のメッセージ:${pageContext.exception.message}</h6>
<h6>例外のタイプ:${pageContext.exception['class'].name}</h6>

</body>
</html>