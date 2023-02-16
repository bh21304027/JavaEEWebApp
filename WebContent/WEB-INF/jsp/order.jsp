<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>注文確認</h2>

<form action="inputorder" method="post">

	<h2>注文者情報</h2>
	<input type="text" name="a" readonly value="ABC">
	名前：<input type="text" name="a" readonly value="${data.UserBean.username}">
	電話番号：<input type="text" name="a" readonly value="${data.AddressBean.addressphonenumber}">
	郵便番号：<input type="text" name="a" readonly value="${data.AddressBean.addresspostcode}">
	住所：<input type="text" name="a" readonly value="${data.AddressBean.addressaddress}">



		<h3>決済方法</h3>
		<p>代引きのみ</p>



		<h3>注文商品</h3>
<c:forEach var="showgoods" items="${data.list2}">

	<input type="text" name="" readonly value="${showgoods.cartsBean.shoesname}"><br>
	<input type="text" name="" readonly value="${showgoods.cartsBean.shoesprice * showgoods.cartBean.count}"><br>
	<input type="text" name="" readonly value="${showgoods.cartsBean.shoespicturepath}"><br>

</c:forEach>
<c:out value="${data.total}"/><br>
<input type="submit" name="a">
</form>
</body>
</html>