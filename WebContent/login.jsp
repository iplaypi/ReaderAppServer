<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	//获取WebContent目录
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="icon" href="<%=basePath%>images/icon_logo.png"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<script type="text/javascript">
	//验证表单中用户名和密码是否为空
	function checkForm() {
		var username = document.getElementById("username").value.trim();
		if ("" == username) {
			document.getElementById("error").innerHTML = "用户名不能为空,请重试.";
			document.getElementById("error").style.color = 'red';
			return false;
		}
		var password = document.getElementById("password").value.trim();
		if ("" == password) {
			document.getElementById("error").innerHTML = "密码不能为空,请重试.";
			document.getElementById("error").style.color = 'red';
			return false;
		}
	}
</script>
<script type="text/javascript" src="<%=basePath%>JS/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/login.css">
</head>
<body>
	<div id="main">
		<div width="1165" height="115">
			<img id="title" src="images/title.gif" border="0" align="middle" />
		</div>
		<div id="login">
			<div id="loginTip"></div>
			<form action="login_login.action" method="post">
				<div id="loginForm" action="javascript:;">
					<div id="loginInfo">
						<input id="username" type="text" autocomplete="off"
							placeholder="请输入用户名" value="${username }" name="username">
						<input id="password" type="password" autocomplete="off"
							placeholder="请输入密码" value="${password }" name="password">
					</div>
					<button id="loginSubmit" type="submit" onclick="return checkForm()">登录</button>
					<p id="error">
						<font color="red">${error}</font>
					</p>
				</div>
			</form>
		</div>
	</div>

</body>
</html>