<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <title></title>
	  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/core.js"></script>
	  <style>
		  html{
			  height:100%;
			  width: 100%;
		  }
		  body{
			  background: #ebebeb;
			  font-family: "Helvetica Neue","Hiragino Sans GB","Microsoft YaHei","\9ED1\4F53",Arial,sans-serif;
			  color: #333;
			  font-size: 12px;
			  height:100%;
			  width: 100%;
		  }
		  *{
			  padding: 0px;
			  margin: 0px;
		  }
		  .top_div{
			  background:url("images/bg.png") no-repeat;
			  background-size: 100% 100%;
			  padding:0px;
			  margin: 0px;
			  width: 100%;
			  height: 100%;
		  }
		  .ipt{
			  border: 1px solid #d3d3d3;
			  padding: 10px 10px;
			  width: 290px;
			  border-radius: 4px;
			  padding-left: 35px;
			  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
			  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
			  -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
			  -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
			  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
		  }
		  .ipt:focus{
			  border-color: #66afe9;
			  outline: 0;
			  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
			  box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
		  }
		  .u_logo{
			  background: url("images/username.png") no-repeat;
			  padding: 10px 10px;
			  position: absolute;
			  top: 70px;
			  left: 40px;

		  }
		  .p_logo{
			  background: url("images/password.png") no-repeat;
			  padding: 10px 10px;
			  position: absolute;
			  top: 28px;
			  left: 40px;
		  }
		  a{
			  text-decoration: none;
		  }
		  .tou{
			  background: url("images/tou.png") no-repeat;
			  width: 97px;
			  height: 92px;
			  position: absolute;
			  top: -87px;
			  left: 140px;
		  }
		  .left_hand{
			  background: url("images/left_hand.png") no-repeat;
			  width: 32px;
			  height: 37px;
			  position: absolute;
			  top: -38px;
			  left: 150px;
		  }
		  .right_hand{
			  background: url("images/right_hand.png") no-repeat;
			  width: 32px;
			  height: 37px;
			  position: absolute;
			  top: -38px;
			  right: -64px;
		  }
		  .initial_left_hand{
			  background: url("images/hand.png") no-repeat;
			  width: 30px;
			  height: 20px;
			  position: absolute;
			  top: -12px;
			  left: 100px;
		  }
		  .initial_right_hand{
			  background: url("images/hand.png") no-repeat;
			  width: 30px;
			  height: 20px;
			  position: absolute;
			  top: -12px;
			  right: -112px;
		  }
		  .left_handing{
			  background: url("images/left-handing.png") no-repeat;
			  width: 30px;
			  height: 20px;
			  position: absolute;
			  top: -24px;
			  left: 139px;
		  }
		  .right_handinging{
			  background: url("images/right_handing.png") no-repeat;
			  width: 30px;
			  height: 20px;
			  position: absolute;
			  top: -21px;
			  left: 210px;
		  }

	  </style>
	  <script type="text/javascript">
		  $(function(){
			  //得到焦点
			  $("#password").focus(function(){
				  $("#left_hand").animate({
					  left: "150",
					  top: " -38"
				  },{step: function(){
						  if(parseInt($("#left_hand").css("left"))>140){
							  $("#left_hand").attr("class","left_hand");
						  }
					  }}, 2000);
				  $("#right_hand").animate({
					  right: "-64",
					  top: "-38px"
				  },{step: function(){
						  if(parseInt($("#right_hand").css("right"))> -70){
							  $("#right_hand").attr("class","right_hand");
						  }
					  }}, 2000);
			  });
			  //失去焦点
			  $("#password").blur(function(){
				  $("#left_hand").attr("class","initial_left_hand");
				  $("#left_hand").attr("style","left:100px;top:-12px;");
				  $("#right_hand").attr("class","initial_right_hand");
				  $("#right_hand").attr("style","right:-112px;top:-12px");
			  });
		  });
	  </script>
  </head>

  <body>
	  <div class="top_div">
		  <h1 style="margin:auto;padding: 30px 200px 10px 0px;text-align: center;color: #fff">教师管理系统</h1>
		  <div style="width: 400px;height: 300px;margin: auto auto;padding: 0px 200px 10px 0px;background: #fff;text-align: center;margin-top: 100px;border: 1px solid #cecece">
			  <div style="width: 165px;height: 96px;position: absolute">
				  <div class="tou"></div>
				  <div id="left_hand" class="initial_left_hand"></div>
				  <div id="right_hand" class="initial_right_hand"></div>
			  </div>

			  <p style="padding: 60px 0px 10px 0px;position: relative;">
				  <span class="u_logo"></span>
				  <input class="ipt" type="text" placeholder="请输入用户名">
			  </p>
			  <p style="padding: 20px 0px 10px 0px;position: relative;">
				  <span class="p_logo"></span>
				  <input id="password" class="ipt" type="password"  placeholder="请输入密码">
			  </p>

			  <div>
				  <p style="margin: 40px 35px 80px 45px;">
					<span style="padding:20px -22px 10px 20px">
						<a href="#" style="background: #12a3ef;padding: 10px 145px;border-radius: 4px;color: #FFF;font-weight: bold;">登录</a>
					</span>
				  </p>
			  </div>
		  </div>
	  </div>
  </body>
</html>
