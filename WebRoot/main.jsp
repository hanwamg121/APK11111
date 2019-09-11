<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<table border="2">
  		<tr>
  			<td>id</td>
  			<td>name</td>
  			<td>type</td>
  			<td>developer</td>
  			<td>time</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${key_list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.type}</td>
                <td>${item.developer}</td>
                <td>${item.time}</td>
                <td><a href="/APK_917106840442/servlet/DelServlet?id=${item.id }">删除</a>|<a href="/APK_917106840442/servlet/ModifyServlet?id=${item.id }">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" ><a href="/APK_917106840442/servlet/AddServlet">添加</a></td>
        </tr>
  	</table>
  </body>
</html>