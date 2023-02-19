<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>SQL例外発生</title>
</head>
<body>
<h1> SQL例外発生　 (; ･`д･´) </h1>

<p>可能性のある原因: </p>
<ul>
<li>値が大きすぎます</li>
<li>オラクルが起動されていません</li>
</ul>
<br>

<p>対処方法: </p>
<ul>
 <li> 入力し直しでください</li>
<li><a href="inputtop">トップページに戻ります。</a></li>
</ul>
<p><font color="#000">
	すみません
</font></p>

<h6>例外のメッセージ:${pageContext.exception.message}</h6>
<h6>例外のタイプ:${pageContext.exception['class'].name}</h6>

</body>
</html>