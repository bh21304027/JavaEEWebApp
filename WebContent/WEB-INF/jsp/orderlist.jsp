<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- <link rel="stylesheet" href="css/cart.css"> -->
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
<main>
<form action="ordercomf" method="Post">
		<c:forEach var="product" items="${data.list2}">
  <!-- <c:out value="${product.cartBean.cartid}"/><br> -->

       画像：<c:out value="${product.shoesProductBean.shoespicture}"/><br>
       商品名：<c:out  value="${product.shoesProductBean.shoesname}"/><br>
       サイズ：<c:out value="${product.shoesProductBean.shoessize}"/><br>
       数：<c:out value="${product.orderBean.count}"/><br>
      価格：<c:out value="${product.price}"/><br>

		</c:forEach>
		<!-- <br>合計金額：<c:out value="${}"/><br> -->
		<input type="submit" value="注文画面へ">
</form>
<a href="inputtop">topにもどる</a>
</main>
</body>
</html>