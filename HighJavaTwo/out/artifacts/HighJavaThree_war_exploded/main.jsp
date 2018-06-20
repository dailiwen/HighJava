<%--
  Created by IntelliJ IDEA.
  User: Dai
  Date: 2018/6/3
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" import="entity.Teacher" %>
<%
    List<Teacher> teachers = (List<Teacher>)request.getAttribute("teachers");
%>
<html>
<head>
    <title>教师信息管理页面</title>
    <link type="text/css" rel="stylesheet" href="CSS/main.css" />
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
    <form action="servlet/Information" method="post">
        <div style="margin-top: 20px;margin-left: 20px">
            <button type="button" id="new" style="width: 90px;height: 40px">新增</button>
            <button type="button" id="change" style="width: 90px;height: 40px">修改</button>
            <button style="width: 90px;height: 40px" id="delete" name="delete">删除</button>
        </div>
        <table id="tableId" class="table table-striped table-hover table-bordered" style="margin-top: 20px">
            <thead style="text-align:center">
            <tr style="background:#0ba8ef; text-align:center; color:#ffffff">
                <th><input type="checkbox" name="father_check"></th>
                <th>ID号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>工资</th>
                <th>学校名称</th>
                <th>专业名称</th>
            </tr>
            </thead>
            <tbody style="text-align:center">
            <% for(int i = 0; i < teachers.size(); i++) { %>
            <tr>
                <td><input type="checkbox" name="check" value="<%=i%>"></td>
                <td><%=teachers.get(i).getId()%></td>
                <td><%=teachers.get(i).getName()%></td>
                <td><%=teachers.get(i).getSex()%></td>
                <td><%=teachers.get(i).getBirthday()%></td>
                <td><%=teachers.get(i).getSalary()%></td>
                <td><%=teachers.get(i).getCollege()%></td>
                <td><%=teachers.get(i).getMajor()%></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </form>
    <form action="servlet/Information" method="post">
        <div id="all">
            <div id="popUp">
                <div id="inforTitle">
                    <span id="inTitle">新增学生信息</span>
                    <img id="imgCancel" src="IMG/X.png">
                </div>
                <div id="inforInput">
                    ID号<input type="text" id="number" name="id" placeholder="请输入ID号"><br>
                    姓名<input type="text" id="name" name="name" placeholder="请输入姓名"><br>
                    性别<input type="text" id="college" name="sex" placeholder="请输入性别"><br>
                    生日<input type="date" id="profession" name="birthday" placeholder="请输入生日" style="width:24%;border-width: 1px"><br>
                    工资<input type="text" id="grade" name="salary" placeholder="请输入工资"><br>
                    学校<input type="text" id="class" name="school" placeholder="请输入学校"><br>
                    专业<input type="text" id="old" name="major" placeholder="请输入专业">
                </div>
                <hr style="background-color:#f1f1f1;border:0px;height:2px"/>
                <div id="inforBottom">
                    <button id="define" name="define">确定</button>
                    <button id="updatedefine" name="updatedefine">确定</button>
                    <button type="button" id="cancel">取消</button>
                </div>
            </div>
        </div>
    </form>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="JS/main.js"></script>
</body>
</html>
