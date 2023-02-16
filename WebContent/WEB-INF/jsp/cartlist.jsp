<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showlist</title>
<link rel="stylesheet"type="text/css" href="<%=request.getContextPath() %>/css/cart.css">
<link rel="stylesheet"type="text/css" href="<%=request.getContextPath() %>/css/header2.css">
<style>
.example{
    display: block;
    width: 300px;
    padding: 15px 0;
    margin: auto;
      background: #333;
    color: #ffff;

    text-decoration: none;
    text-align: center;
}
.example:hover{
     background: #ffffff;
    color: #333;
}
</style>
</head>
<body>
 <header>
        <div>
        <header class="header-div">
        <nav class="pc-nav">
            <ul class="header-ul">
                <li class="header-li"><a class="header-a" href="inputupdateuser">ユーザー情報の変更</a></li>
                <li class="header-li"><a class="header-a" href="#">注文検索</a></li>
                <li class="header-li"><a class="header-a" href="inputlogin">ログイン</a></li>

            </ul>
        </nav>
        </header>
        </div>

        <!--<div class="image"><a href=""><img src="images/anodidasu.png" class=""></a></div>-->
          <div class="wrap">
<span class="decor"></span>
                <nav>
                  <ul class="primary">


                    <li>
                      <a  class="atag" href="getgenderproduct?gender=0">メンズ</a>
                      <ul class="sub">
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=0&category=1">スニーカー</a></li>
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=0&category=2">サンダル</a></li>
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=0&category=3">サッカースパイク</a></li>
                      </ul>
                    </li>
                    <li>
                      <a class="atag" href="getgenderproduct?gender=1">レディース</a>
                      <ul class="sub">
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=1&category=1">スニーカー</a></li>
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=1&category=2">サンダル</a></li>
                        <li><a class="atag" href="getgenderandcategoryproduct?gender=1&category=3">サッカースパイク</a></li>
                      </ul>
                    </li>
                    <li>
                      <a class="atag" href="getgenderproduct?gender=2">キッズ</a>
                      <ul class="sub">
                        <li><a class="atag" href="">キッズ</a></li>
                      </ul>
                    </li>
                    <li>
                    <div class="searchbox">
                      <form id="form4" action="自分のサイトURL" method="get">
                          <input id="sbox4"  id="s" name="s" type="text" placeholder="フリーワードを入力" />
                          <button id="sbtn4" type="submit"><i class="fas fa-search"></i></button></form></div>
                      </li>
                      <li>
                          <div class="heartsvg" id="heartId"><a href="#" class="icon">
                            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 28 28" class="heart" id="heartSvg">
                              <title>iconHeartFill</title>
                              <path d="M14.014 27.166c-3.419-2.915-6.951-6.026-9.585-9.053s-4.428-6.026-4.428-8.745c0-2.046 0.841-3.952 2.242-5.353s3.307-2.242 5.409-2.242c1.317 0 2.579 0.364 3.672 0.925s2.046 1.457 2.691 2.466c0.645-1.009 1.598-1.878 2.691-2.466s2.354-0.925 3.672-0.925c2.102 0 4.008 0.841 5.409 2.242s2.242 3.307 2.242 5.353c0 3.279-1.794 6.222-4.428 9.137-1.317 1.457-2.831 2.915-4.484 4.344s-3.363 2.859-5.101 4.316z">

                            </path></svg></a>
                          </div>
                          </li>
                          <li>

                          <div class="cartsvg" id="cartId"><a href="showcart" class="icon">
                          <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 28 28" class="cart" id="cartSvg">
						<title>icon</title>
                          <path d="M2.635 28.035h4.148l-3.784-3.756zM3.251 21.869l6.166 6.166h2.747l-8.688-8.632zM3.728 17.020l11.043 11.015h2.747l-13.537-13.509zM23.403 6.931h-3.363c0-3.335-2.691-6.026-6.026-6.026s-6.026 2.691-6.026 6.026h-3.363l-0.42 5.045 15.948 16.060h5.241l-1.99-21.105zM14.014 2.39c2.494 0 4.54 2.046 4.54 4.54h-9.053c0-2.494 2.018-4.54 4.512-4.54z">
                          </path></svg></a></div></li>

                  </ul>
                </nav>



<script src="<%=request.getContextPath() %>/js/header.js"></script>


 </div></header>
    <main>

    <div class="flex">
	<div class = "products">
        <div class="product">

		<c:forEach var="product" items="${data.list2}">
			<table class="table">
  <tr>
  <td class="table-img">
  <img src="<%=request.getContextPath() %>/image/${product.cartsBean.shoespicturepath}" width="150px" height="150px"alt="sohes">
</td>
    <td class="table-txt">
       <p class="texttype">${product.cartsBean.shoesname}</p>
      <a class="texttype3">${product.cartsBean.shoesprice * product.cartBean.count}円</a>
      <a class="texttype4"><c:out value="${product.cartBean.count}"/>個</a>
     <a class="texttype2"> サイズ:${product.cartsBean.shoessize}</a><br>
       <a href="deletecart?cartid=${product.cartBean.cartid}">削除</a>


 </td>
  </tr>
</table>
		</c:forEach>

			</div>
			<a href="inputtop">topにもどる</a>

	</div>

	<div class="pay" style="height: 200px"><div class="paypay">
            <a href="ordercomf" class="button">購入手続きに進む</a>
        </div>
        <c:out value="${product.productCount}"/><br>
        <div class="flex1">
            <span class="span">数量</span><div class="formula"><c:out value="${data.count}"/><br></div>
        </div>
        <div class="flex1">
            <span class="span" >合計代金</span><div class="formula"><c:out value="${data.total}"/><br></div>
        </div>

    </div>
</div>
</form>
</main>
</body>
</html>