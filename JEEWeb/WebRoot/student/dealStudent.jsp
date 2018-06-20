<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="student.Student"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>请求处理页面</title>
  </head>
  <body>
    <%
    	String handType = request.getParameter("handType");
    	if("add".equals(handType)){
    		String stuNo = request.getParameter("stuNo");
        	String stuName = request.getParameter("stuName");
        	String stuSex = request.getParameter("stuSex");
        	int stuAge = Integer.valueOf(request.getParameter("stuAge"));
        	
        	Student student = new Student(stuNo, stuName, stuSex, stuAge);
        	Map<String,Student> stuMap = (Map<String,Student>)session.getAttribute("stuMap");
        	
        	if (stuMap == null) {
        		stuMap = new HashMap<String, Student>();
        	}
        	
        	stuMap.put(stuNo,student);
        	session.setAttribute("stuMap",stuMap);
        	
    	}else if("del".equals(handType)){
    		String stuNo = request.getParameter("stuNo");
    		Map<String,Student> stuMap = (Map<String,Student>)session.getAttribute("stuMap");
    		stuMap.remove(stuNo);
    	}else{
    		
    	}
    	response.sendRedirect("showStudents.jsp");
    %>
  </body>
</html>
