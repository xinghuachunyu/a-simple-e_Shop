<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<table width="80%" border="1"align="center">
  <tr>
    <td height="51" colspan="2" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr><tr>
    <td width="33%" height="147" align="center">
    <jsp:include flush="true" page="left.jsp"></jsp:include></td>
    <td  valign="top" height="147"align="center">
    <jsp:include flush="true" page="right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="76" colspan="2" align="center">
    <jsp:include flush="true" page="end.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>