<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- 防止退出后,在登录页面返回又回退到登录页面 -->
<script type='text/javascript'>
	window.history.forward();
	window.onbeforeunload = function() {
	}
</script>

<%
	//获取WebContent目录
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="icon" href="<%=basePath%>images/icon_logo.png"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ReaderApp后台管理系统</title>

<!-- 可选的Bootstrap主题文件 -->
<link href="<%=basePath%>CSS/bootstrap-combined.min.css"
	rel="stylesheet">

<!-- 引入easyUI库,注意路径不能错误 -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		// 数据
		var treeData = [ {
			text : "菜单目录",

			children : [ {
				text : "基础功能",
				state : "open",
				children : [ {
					text : "编辑首页",
					attributes : {
						url : "home_list.action"
					}
				}, {
					text : "添加首页",
					attributes : {
						url : "home_addUI.action"
					}
				}, {
					text : "编辑文章",
					attributes : {
						url : "article_list.action"
					}
				}, {
					text : "添加文章",
					attributes : {
						url : "article_addUI.action"
					}
				}, {
					text : "编辑图片",
					attributes : {
						url : "picture_list.action"
					}
				}, {
					text : "添加图片",
					attributes : {
						url : "picture_addUI.action"
					}
				} ]
			}, {
				text : "上传功能",
				state : "open",
				children : [ {
					text : "文件列表",
					attributes : {
						url : "upload_list.action"
					}
				}, {
					text : "上传文件",
					attributes : {
						url : "upload_addUI.action"
					}
				}, {
					text : "删除文件",
					attributes : {
						url : "upload_deleteUI.action"
					}
				} ]
			}, {
				text : "关于用户",
				state : "open",
				children : [ {
					text : "用户信息",
					attributes : {
						url : "login_infoUI.action"
					}
				}, {
					text : "修改密码",
					attributes : {
						url : "login_updateUI.action"
					}
				} ]
			} ]
		} ];

		// 实例化树菜单
		$("#tree").tree({
			data : treeData,
			lines : true,
			onClick : function(node) {
				if (node.attributes) {
					openTab(node.text, node.attributes.url);
				}
			}
		});

		// 新增Tab
		function openTab(text, url) {
			if ($("#tabs").tabs('exists', text)) {
				$("#tabs").tabs('select', text);
			} else {
				// 多个iframe共用一个session,可以
				var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="
						+ url + "></iframe>";
				$("#tabs").tabs('add', {
					title : text,
					closable : true,
					content : content
				});
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 80px; background-color: #E0EDFF">
		<div align="left"
			style="height: 74px; background: url(<%=basePath%>images/title_bg.jpg) no-repeat;">
			<div style="margin-top: 8px; margin-right: 60px; float: right;">
				<p style="font-size: 1.2em; color: blue; text-align: center;">
					<img src="<%=basePath%>images/icon_user_online_16x16.png"
						width=16px height=16px border="0" align="middle" />当前用户:
					${currentUser._username }
				</p>
				<a href="login_exit.action"
					style="font-size: 1.2em; color: blue; text-align: center;"><img
					src="<%=basePath%>images/icon_logout_16x16.png" width=16px
					height=16px border="0" align="middle" />退出</a>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页">
				<div align="center">
					<img src="<%=basePath%>images/bg_main.jpg" height="100%"
						width="100%">
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 150px;" title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height: 30px;" align="center">
		<font size="4">制作: </font><a style="margin-right: 30px"><font
			size="4">广东工业大学</font></a> <a style="margin-right: 30px"><font
			size="4">计算机科学与技术12级4班</font></a> <a><font size="4">刘鹏飞</font></a>
	</div>
</body>
</html>