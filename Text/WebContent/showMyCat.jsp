<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page language="java" import="java.util.*,usersmodel.*,usersservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"type="text/css" href="css/mycss.css" >
</head>
<body>
<%
usersBean ub=(usersBean)request.getAttribute("ub");
MyCatCL mcl=(MyCatCL)request.getSession().getAttribute("mycat");
%>
<table width="100%" border="1">
  <tr align="center">
    <td>
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr align="center">
    <td><table width="100%" border="1" class="abc">
      <tr align="center">
        <td colspan="6"><img src="imags/big11.jpg" width="606" height="80" /></td>
        </tr>
      <tr align="center" class="color">
        <td>用户名</td>
        <td>邮箱</td>
        <td>联系方式</td>
        <td>收货地址</td>
        <td>货物ID</td>
        <td>总价</td>
      </tr>
      <tr align="center">
        <td><%=ub.getUsername() %></td>
        <td><%=ub.getEmail() %></td>
        <td><%=ub.getPhone() %></td>
        <td><%=ub.getAddress() %></td>
        <td><%=mcl.returngoodsid() %></td>
        <td>￥：<%=mcl.returnallprice() %></td>
      </tr>
      <tr>
        <td colspan="6" align="center"><form id="form1" name="form1" method="post" action="success.jsp">
          <input type="submit" name="button" id="button" value="确 认 支 付" />
        </form></td>
        </tr>
      <tr>
        <td colspan="6">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr align="center">
    <td>
    <jsp:include flush="true" page="end.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>