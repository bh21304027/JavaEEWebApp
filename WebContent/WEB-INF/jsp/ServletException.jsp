<%@ page pageEncoding="UTF-8"
	isErrorPage="true"
	contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>例外発生</title>
</head>
<body>
<h1> サーブレット例外発生しました　 ( ;∀;)</h1>

<p>可能性のある原因: </p>
<ul>
<li>サーブレットに何らかの問題が発生しています。</li>
<li>tomcatに何らかの問題が発生しています。</li>
</ul>
<br>

<p>対処方法: </p>
<ul>
 <li> 管理者に連絡してください</li>
<li><a href="inputtop">トップページに戻ります。</a></li>
</ul>
<p><font color="#000">
	すみません
</font></p>

<h6>例外のメッセージ:${pageContext.exception.message}</h6>
<h6>例外のタイプ:${pageContext.exception['class'].name}</h6>

</body>
</html>