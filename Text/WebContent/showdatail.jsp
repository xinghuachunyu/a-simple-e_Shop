<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page language="java" import="java.sql.*,java.util.*,goodsmodel.*,goodsservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
<script type="text/javascript">
<!--
     function logon()
     {
        open("index.jsp","_self");
     }
	 function Buy(goodsid)
	{
		open("MyCatServlet?flag=buy&goodsid="+goodsid,"_self");
	}
 -->
</script>
</head>
<body>
<%
goodsBean gb=(goodsBean)request.getAttribute("gb");
%>
<table width="100%" border="0" class="abc">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="394"><table width="100%" border="0">
      <tr>
        <td width="40%" rowspan="5" align="center"><img src="imags/<%=gb.getPhoto()%>" width="400" height="380" /></td>
        <td width="60%">商品名字：<%=gb.getGoodsName() %></td>
      </tr>
      <tr>
        <td height="25">商品价钱：￥<%=gb.getGoodsPrice() %></td>
      </tr>
      <tr>
        <td height="23">商品品牌：<%=gb.getPublisher() %></td>
      </tr>
      <tr>
        <td height="23">商品介绍：<%=gb.getGoodsInro() %></td>
      </tr>
      <tr>
        <td>
          <input type="button" name="button1" id="button1"value="购买" Onclick="Buy(<%=gb.getGoodsID() %>)" /> 
            <input type="button" name="button2" id="button2" value="返回购物大厅" Onclick="logon()"/>
       </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="end.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>