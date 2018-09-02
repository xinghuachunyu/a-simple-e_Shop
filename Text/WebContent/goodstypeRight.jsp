<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page language="java" import="java.util.*,goodsmodel.*,goodsservlet.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%
 int pagecount=(int)request.getAttribute("pagecount"); 
goodsBeanCL gbc=new goodsBeanCL();
String goodstype=(String)request.getAttribute("goodstype");
ArrayList<goodsBean> al=(ArrayList<goodsBean>)request.getAttribute("al");
%>
<table width="100%" border="0" class="abc">
  <tr class="abc">
    <td colspan="3" align="center"><img src="imags/151151336708108417.jpg" width="100%" height="60" /></td>
  </tr>
 <%
        int time=0;
        for(int i=0;i<2;i++)
        {
        %>
	    <tr align="center">
		<%
		
		 for(int j=0;j<3;j++)
		 {
			 goodsBean gb=new goodsBean();
			 if(time>=al.size())
			 {
				gb.setGoodsID(35);
				gb.setGoodsInro("没有了，哈哈哈");
				gb.setGoodsName("无");
				gb.setGoodsPrice(0);
			 }
			 else
			 {
			 gb=(goodsBean)al.get(time);
			 time++;			 
			 }
			
		 %>
			 <td class="abc"><table width="100%" border="0">
	      <tr>
	        <td rowspan="3" align="center"><img src="imags/<%=gb.getPhoto() %>" width="100" height="60" /></td>
	        <td align="center"><a href="userdatailservlet?flag=datail&id=<%=gb.getGoodsID()%>">货物id号：<%=gb.getGoodsID() %></a></td>
	        </tr>
	      <tr>
	        <td align="center">名称：<%=gb.getGoodsName() %></td>
	        </tr>
	      <tr>
	        <td align="center">价格：￥<%=gb.getGoodsPrice() %></td>
	        </tr>
	      <tr>
	        <td colspan="2" align="center">介绍：<%=gb.getGoodsInro() %></td>
	        </tr>
	    </table></td>
		 <%
	 }
	%>
	</tr>
	<%
	if(i==0)
	{
		%>
		
		<tr align="center" class="abc">
	    <td colspan="3" bgcolor="#FF6699">&nbsp;</td>
	    </tr>
		<%
	}
}
%>
  <tr align="center" class="abc">
    <td colspan="3">
<%
for(int i=1;i<=pagecount;i++)
{
	%>
	<a href="userdatailservlet?flag=type&goodstype=<%=goodstype %>&pageNow=<%=i%>">[<%=i%>]</a>
	<%
}
%>
</td>
  </tr>
</table>