<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@page import="student.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加学生</title>
  </head>
  <body>
    <form action="student/dealStudent.jsp?handType=add" method="post">
    	学号： <input type="text" name="stuNo"><br>
    	姓名： <input type="text" name="stuName"><br>
    	年龄： <input type="text" name="stuAge"><br>
    	性别: <input type="radio" name="stuSex" value="男">男 <input type="radio" name="stuSex" value="女">女<br><br>
    	<input type="submit" value="提交"><input type="reset" value="重置">
    </form>
  </body>
</html>
