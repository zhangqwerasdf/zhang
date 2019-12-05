<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<script src="jquery/jquery.js" > </script>
<script src="jquery/jquery.validate.min.js" >  </script>
<script src="jquery/messages_zh.js" >  </script>
    <title>登录页面</title>
  <link rel="stylesheet" type="text/css" href="jquery/logincss.css" charset="utf-8"/> 

<script type="text/javascript">
	$().ready(function() {
		$("#for1").validate({
			rules:{
				username:{
					required:true,
					minlength:1,
					maxlength:12
				},
				password:{
					required:true,
					minlength:1,
					maxlength:12
				}
								
			},
			messages:{
				username:{
					required:"请输入账号",
					minlength:"账号长度最小为1位",
					maxlength:"账号长度最大为12位"
				},
				password:{
					required:"请输入密码",
					minlength:"账号长度最小为1位",
					maxlength:"账号长度最大为12位"
				}
					
			}
		});

	})
</script>

<style type="text/css">
.error{
	color:red;
}
</style>

</head>
<body >

<div id="Max_div">
    <div id="div1">
        <div id="div2">
            <img src="js/z/logo.png">
            <h3>智游客户关系管理系统</h3>
        </div>
        <div id="div4">
        	<form id="for1" action="http://localhost:8080/SSMVideo/jsp/HomePage.jsp" method="post" name="for1" onsubmit="return check()">
	            <input type="text" class="text1" name="username" placeholder="请输入用户名">
	            <br>
	            <input type="password" class="text1" name="password" placeholder="请输入密码" >
	            <br>
	            <input type="submit" id="input1" class="button1" value="登录" >
	            <br>
	            
	            
            </form>
            <a href="http://localhost:8080/SSMVideo/jsp/register.jsp"><input type="submit" id="input1" class="button1" value="没有账号?点我注册" >
                </a>
            <c:if test="${!empty msg }">
            	${msg}
            </c:if>
        </div>
    </div>
</div>
<%-- <c:if test="">

</c:if> --%>
<script type="text/javascript">
	
	function check() {
		if(document.for1.username.value.length<1){
			alert("账号不能为空！");
			return false;
		}
		if(document.for1.password.value.length<1){
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
	
</script>

</body>
</html>