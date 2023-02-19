<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>クラスが見つかりません</title>
</head>
<body>
<h1> クラスが見つかりません　 (; ･`д･´) </h1>

<p>可能性のある原因: </p>
<ul>
<li>ソースに例外発生</li>
<li>オラクルが起動されていません</li>
</ul>
<br>

<p>対処方法: </p>
<ul>
 <li> 管理者に連絡</li>
<li><a href="inputtop">トップページに戻ります。</a></li>
</ul>
<p><font color="#000">
	すみません
</font></p>

<h6>例外のメッセージ:${pageContext.exception.message}</h6>
<h6>例外のタイプ:${pageContext.exception['class'].name}</h6>

</body>
</html>