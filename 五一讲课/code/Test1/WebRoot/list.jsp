<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生列表展示</title>
    

  </head>
  
  <body>
  	<table align="center" border="1">
  		<caption>学生列表展示</caption>
  		<tr>
  			<th>姓名</th>
  			<th>性别</th>
  			<th>年龄</th>
  		</tr>
  		<c:forEach items="${requestScope.pageBean.list }" var="vr">
  			<tr>
  				<td>${vr.name }</td>
  				<td>${vr.sex }</td>
  				<td>${vr.age }</td>
  			</tr>
  		</c:forEach>
  		<tr align="center">
  			<td colspan="3">
  				<a href="${basePath }StudentServlet?curPage=${requestScope.pageBean.curPage-1}">上一页</a>
  				<a href="${basePath }StudentServlet?curPage=${requestScope.pageBean.curPage+1}">下一页</a>
  				<a href="${basePath }StudentServlet?curPage=1">首页</a>
  				<a href="${basePath }StudentServlet?curPage=${requestScope.pageBean.totalPage}">尾页</a>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
