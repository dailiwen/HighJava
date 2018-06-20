<%@page import="org.cqut.hr.teacher.Teacher"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Teacher>  teachers = (List<Teacher>)request.getAttribute("teachers");

%>

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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<table border=1>
  	<tr><td>name</td><td>age</td><td></td></tr>
    <% for(Teacher teacher : teachers) { %>
    	<tr><td><%=teacher.getName() %></td><td><%=teacher.getAge() %></td><td><a href="editTeacher?name=<%=teacher.getName() %>">edit</a>   <a href="">del</a></td></tr>
    <% } %>
    </table>
  </body>
</html>
