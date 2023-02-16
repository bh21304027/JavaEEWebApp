<%@ page pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>ユーザー情報変更</title>
</head>
<body>
    <h1>ユーザー情報変更</h1>
    <form method="post" action="updateuser">
			<input type="hidden" name="userid" value='${data.userid}'>
        ユーザー名<input type="text" name="username" placeholder='${data.username}' value='${data.username}'><br>
        誕生日<input type="date" name="userdob" placeholder='${data.userdob}' value='${data.userdob}'><br>
			<input type="hidden" name="addressid" value='${data.addressid}'>
        電話番号<input type="text" name="phonenumber" placeholder='${data.addressphonenumber}'  value='${data.addressphonenumber}'><br>
        郵便番号<input type="text" name="postcode" placeholder='${data.addresspostcode}' value='${data.addresspostcode}'><br>
       	住所<input type="text" name="address" placeholder='${data.addressaddress}' value='${data.addressaddress}'><br>
       		<input type="hidden" name="state" value='${data.state}'>

        <input type="submit" value="変更">
    </form>
</body>
</html>