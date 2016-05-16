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
<title>查看article</title>

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
</head>
<body style="margin: 5px;">

	<div class="easyui-panel" title="文章列表" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">
			<table cellpadding="1" class="table table-bordered">
				<caption>
					<a style="float: left;" href="article_list.action"><font
						size="4">刷新</font><img id="title"
						src="<%=basePath%>images/refresh.png" width=24 height=24
						border="0" align="middle" /></a>
				</caption>
				<thead>
					<tr>
						<th>编号</th>
						<th>标题</th>
						<th>作者</th>
						<th>日期</th>
						<th>阅读量</th>
						<th>点赞量</th>
						<th>编辑</th>
						<th>删除</th>
						<th>更多信息</th>
					</tr>
				</thead>
				<tbody>

					<s:iterator value="#list">
						<tr>
							<td><s:property value="_articlePageID" /></td>
							<td><s:property value="_title" /></td>
							<td><s:property value="_author" /></td>
							<td><s:property value="_date" /></td>
							<td><s:property value="_readCount" /></td>
							<td><s:property value="_likeCount" /></td>

							<!-- 编辑需要主键,不是pageID,注意区分 -->
							<td><s:a action="article_editUI?_id=%{_id}">编辑</s:a></td>
							<td><s:a action="article_delete?_id=%{_id}"
									onclick="return confirm('确认删除吗?')">删除</s:a></td>
							<td><s:a action="article_infoUI?_id=%{_id}">更多信息</s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>