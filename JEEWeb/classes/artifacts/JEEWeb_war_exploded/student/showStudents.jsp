<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@page import="student.Student"%><%@page import="java.util.Map.Entry"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>显示所有学生</title>
  </head>
  <body>
    <table border="1">
    	<thead>
    		<tr><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>操作</td></tr>
    	</thead>
    	<%
    		Map<String, Student> map = (Map<String, Student>) session.getAttribute("stuMap");
    		if (map != null) {
    		Iterator<Entry<String,Student>> it = map.entrySet().iterator();
    		while (it.hasNext()) {
    			Entry<String, Student> entry = (Entry<String, Student>) it.next();     
    		     Student stu =  (Student)entry.getValue();
    	%>
    	<tr>
	    	<td><%=stu.getStuNo()%></td>
	    	<td><%=stu.getStuName() %></td>
	    	<td><%=stu.getStuSex()%></td>
	    	<td><%=stu.getStuAge() %></td>
	    	<td><a href="student/dealStudent.jsp?handType=del&stuNo=<%=stu.getStuNo()%>">删除</a></td>
    	</tr>
    		<% }} %>
    </table>
	<a href="student/addStudent.jsp?handType=add">添加</a>
  </body>
</html>
