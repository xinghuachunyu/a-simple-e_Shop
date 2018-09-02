<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="colee_left" style="overflow:hidden;width:500px;">  
  
<table cellpadding="0" cellspacing="0" border="0">  
  
<tr><td id="colee_left1" valign="top" align="center">  
  
<table cellpadding="2" cellspacing="0" border="0">  
  
<tr align="center">  
  
<td><p><img src="imags/big1.jpg" width="100" height="60"></p></td>  
  
<td><p><img src="imags/big2.jpg"width="100" height="60"></p></td>  
  
<td><p><img src="imags/big3.jpg"width="100" height="60"></p></td>  
  
<td><p><img src="imags/big4.jpg"width="100" height="60"></p></td>  
  
<td><p><img src="imags/big5.jpg"width="100" height="60"></p></td>  
  
<td><p><img src="imags/big6.jpg"width="100" height="60"></p></td>  
  
</tr>  
  
</table>  
  
</td>  
  
<td id="colee_left2" valign="top"></td>  
  
</tr>  
  
</table>  
  
</div>  
  
<script>  
  
//使用div时，请保证colee_left2与colee_left1是在同一行上.  
  
var speed=30//速度数值越大速度越慢 
  
var colee_left2=document.getElementById("colee_left2");  
  
var colee_left1=document.getElementById("colee_left1");  
  
var colee_left=document.getElementById("colee_left");  
  
colee_left2.innerHTML=colee_left1.innerHTML  
  
function Marquee3(){  
  
if(colee_left2.offsetWidth-colee_left.scrollLeft<=0)//offsetWidth 是对象的可见宽度  
  
colee_left.scrollLeft-=colee_left1.offsetWidth//scrollWidth 是对象的实际内容的宽，不包边线宽度  
  
else{  
  
colee_left.scrollLeft++  
  
}  
  
}  
  
var MyMar3=setInterval(Marquee3,speed)  
  
colee_left.onmouseover=function() {clearInterval(MyMar3)}  
  
colee_left.onmouseout=function() {MyMar3=setInterval(Marquee3,speed)}  
  
</script>  
