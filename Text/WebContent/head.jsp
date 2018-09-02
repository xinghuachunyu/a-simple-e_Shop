<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page language="java" import="java.util.*,usersservlet.*,usersmodel.*" %>
 <%
 usersBeanCL ubc=(usersBeanCL)request.getSession().getAttribute("mydatail");
 String u=(String)request.getSession().getAttribute("username");
 if(u==null)
 {
	 response.sendRedirect("login.jsp");
 }
 %>
<table width="100%" border="0" class="abc">
  <tr>
    <td height="10" colspan="3" bgcolor="#FF3366"></td>
  </tr>
  <tr>
    <td width="36%" height="150" bgcolor="#FFFFFF"><img src="imags/150338612019892140.png" width="341" height="121" /></td>
    <td width="36%"><img src="imags/u=2297777653,2230047592&amp;fm=27&amp;gp=0.jpg" width="365" height="139" /></td>
    <td width="14%" align="left" valign="middle"><p class="abc"><img src="imags/u=1401295400,1349742606&amp;fm=27&amp;gp=0.jpg" width="48" height="18" /> 
        <a href="loginCLservlet?flag=orlogin">【我的账号：<%=u%>】</a></p>
    <p><img src="imags/download.jpg" width="47" height="26" /> <a href="MyCatServlet?flag=mycat">【我的购物车】</a></p></td>
  </tr>
  <tr>
    <td colspan="3" height="10"bgcolor="#FF3366"></td>
  </tr>
  <tr>
    <td colspan="3"><table width="100%" border="1">
      <tr>
       <td width="10">&nbsp;</td>
        <td width="10" class="color"><a href="index.jsp">首页</a></td>
        <td width="10">&nbsp;</td>
        <td width="10" class="color"><a href="userdatailservlet?flag=type&goodstype=clothing">服装</a></td>
        <td width="10">&nbsp;</td>
        <td width="10" class="color"><a href="userdatailservlet?flag=type&goodstype=book">书籍</a></td>
        <td width="10">&nbsp;</td>
        <td width="10" class="color"><a href="userdatailservlet?flag=type&goodstype=food">食品</a></td>
        <td width="10">&nbsp;</td>
        <td width="10" class="color"><a href="userdatailservlet?flag=type&goodstype=electronic">家电</a></td>
      </tr>
    </table></td>
  </tr>
</table>