<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件列表</title>

<!-- 可选的Bootstrap主题文件 -->
<link href="<%=basePath%>CSS/bootstrap-combined.min.css"
	rel="stylesheet">

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
<style type="text/css">
.comments {
	width: 800px;
	overflow: auto;
	word-break: break-all;
}
</style>
</head>
<body style="margin: 5px;">
	<div class="easyui-panel" title="文件列表" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">
			<table cellpadding="1" class="table table-bordered">
				<caption>
					<s:a style="float: left;" href="upload_list.action">
						<font size="4">刷新</font>
						<img id="title" src="<%=basePath%>images/refresh.png" width=24
							height=24 border="0" align="middle" />
					</s:a>
				</caption>
				<thead>
					<tr>
						<th>文件类型</th>
						<th>文件uri</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>首页图片uri:</td>
						<td><s:select list="#homeImagesSrc" class="comments"></s:select></td>
					</tr>
					<tr>
						<td>音乐图标uri:</td>
						<td><s:select list="#musicImage" class="comments"></s:select></td>
					</tr>
					<tr>
						<td>音乐文件uri:</td>
						<td><s:select list="#musicURL" class="comments" /></td>
					</tr>
					<tr>
						<td>图片uri:</td>
						<td><s:select list="#pictureImagesSrc" class="comments"></s:select></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>