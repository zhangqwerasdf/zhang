<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>XX系统 - 登录页面</title>
	<link rel="stylesheet" href="css/index.css">
<style type="text/css">
	* {
	box-sizing: border-box;
	font-family: 微软雅黑;
}
html,body {
    height: 100%;
}
body {
	margin: 0;
    background-color: #ddd;
    display: flex;
    justify-content: center;
    align-items: center;
}
.login {
    background-color: #fff;
    width: 340px;
    padding-top: 30px;
    border-radius: 5px;
}
.login img {
    display: block;
    width: 150px;
    margin: 0 auto;
}
p {
    text-align: center;
    margin: 10px 0;
    color: #888;
    padding-bottom: 5px;
}
form {
    padding: 0 30px 20px 30px;
}
input {
    height: 40px;
    width: 100%;
    margin: 5px 0;
    outline: none;
    border: 1px solid #aaa;
    padding-left: 10px;
    font-size: 14px;
}
input:focus {
    border: 1px solid #d70f18;
}
input[type=submit] {
    width: 100%;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    background-color: #d70f18;
    border: none;
    color: #fff;
    padding: 0;
    margin: 5px 0;
    cursor: pointer;
}
.error-message {
	color: #d70f18;
	margin: 3px 0;
}
</style>
</head>
<body>
<div class="login">
	<img src=" z/logo.png " alt="智游">
	<!-- <img src="image/0.jpg" alt="智游2"> -->
	<p>管理员登录</p>
	<form action="adminlogin" method="post">
	<div>
		<input type="text" id="accounts" name="accounts" value="" placeholder="请输入用户名">
	</div>
	<div>
		<input type="password" id="password" name="password" value="" placeholder="请输入密码">
	</div>
	<div>
		<p class="error-message">${msg }</p>
		<input type="submit" value="登录">
	</div>
	</form>
</div>
<script>
	if (window.top !== window) {
		window.top.location.reload();
	}
</script>
</body>
</html>