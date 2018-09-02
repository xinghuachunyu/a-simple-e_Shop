<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page language="java" import="java.util.*,usersmodel.*,usersservlet.*,goodsmodel.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<script type="text/javascript">
<!--
function deletall()
{
	open("MyCatServlet?flag=deletall","_self");
	}

-->
</script>
</head>
<body>
<%
ArrayList<goodsBean> al=(ArrayList)request.getAttribute("goods");
MyCatCL mcl=(MyCatCL)request.getSession().getAttribute("mycat");
%>
<center>
<table width="100%" border="1">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
</td>
  </tr>
  <tr>
    <td align="center">    
    <table width="100%" border="1" class="abc">
      <tr>
        <td colspan="6" align="center"><img src="imags/big11.jpg" width="700" height="80" /></td>
        </tr>
      <tr align="center" class="color">
      <form action="MyCatServlet?flag=updatenum" method="post">
      <table width="100%" border="1" class="abc">
      <tr >
        <td width="26%" align="center">货物id号</td>
        <td width="24%" align="center">名称</td>
        <td width="23%" align="center">价格</td>
        <td colspan="3" align="left">数量</td>
      </tr>
     <%
     for(int i=0;i<al.size();i++)
     {
    	 goodsBean gb=(goodsBean)al.get(i);
    	 %>
    	  <tr align="center">
        <td><%=gb.getGoodsID() %></td>
        <td><%=gb.getGoodsInro() %></td>
        <td>￥：<%=gb.getGoodsPrice() %></td>
        <td width="7%"><input type="hidden" name="goodsid" value="<%=gb.getGoodsID()%>"><input type="text" name="goodsNum" value="<%=mcl.goodsnewNum(gb.getGoodsID()+"")%>"></td>
        <td width="11%"><a href="MyCatServlet?flag=delet&goodsid=<%=gb.getGoodsID()%>">删除</a></td>
        <td width="9%"><a href="userdatailservlet?flag=datail&id=<%=gb.getGoodsID()%>">详情</a></td>
      </tr>
    	 <%
     }
     %>
     
      <tr align="center">
        <td colspan="6"><input type="button" name="button1" id="button1" value="删除所有货物" Onclick="deletall()"/>
        &nbsp&nbsp&nbsp&nbsp<input type="submit"  value="修 改 数 量" /></td>
        </tr>
        </table>
        </form>
        </tr>
      <tr align="center" >
      <table width="100%" border="1">
      <tr>
        <td colspan="2" align="left"class="abc">你所购买商品的总价格为：￥<%=mcl.returnallprice() %>，请点击这里<a href="index.jsp">返回首页</a></td>
        <td colspan="4" align="right"class="abc"><a href="loginCLservlet?flag=showuserdatail">下一步</a></td>
        </tr>
        </table>
        </tr>
      <tr align="center">
        <td colspan="6">&nbsp;</td>
        </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="end.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
</body>
</html>