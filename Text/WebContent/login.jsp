<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<!--
function Login()
{
	open("loginCLservlet","_self");
}
function zhuche()
{
	open("Register.jsp","_self");
}
-->
</script>
</head>
<body background="imags/big9.jpg" >
<form name="from1" method="post" action="loginCLservlet?flag=login">
<center >
<h1>用户注册/登录</h1>
<hr>
<table align="center">
<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>密&nbsp&nbsp码：</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="button1" value="登录" >&nbsp&nbsp&nbsp&nbsp
<input type="button" name="button2" value="注册" Onclick="zhuche()">
</td>
</tr>
</table>
</center>
</form>

</body>
</html>