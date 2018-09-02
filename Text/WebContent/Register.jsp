<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="imags/big10.jpg">
<form  method="post" action="usersCLservlet">
<center >
<h1>用户注册</h1>
<hr>
<table align="center">
<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>真实姓名：</td>
<td><input type="text" name="truename"></td>
</tr>
<tr>
<td>密&nbsp&nbsp码：</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>电子邮件：</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>电话号码：</td>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<td>用户地址：</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td>邮编：</td>
<td><input type="text" name="postcode"></td>
</tr>
<tr>
<td>用户级别：</td>
<td><input type="text" name="grade"></td>
</tr>
<tr>
<td align="center"colspan="2"><input type="submit" name="button1" value="确认"></td>
</tr>
</table>
</center>
</form>
</body>
</html>