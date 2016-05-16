<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<title>查看图片</title>

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
<!-- 控制宽度的自动适应 -->
<style type="text/css">
.comments {
	/*自动适应父布局宽度*/
	width: 800px;
	overflow: auto;
	word-break: break-all;
	/*在ie中解决断行问题(防止自动变为在一行显示，主要解决ie兼容问题，ie8中当设宽度为100%时，文本域类容超过一行时，  
当我们双击文本内容就会自动变为一行显示，所以只能用ie的专有断行属性“word-break或word-wrap”控制其断行)*/
}
</style>
</head>
<body style="margin: 5px;">

	<div class="easyui-panel" title="更多信息" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">

			<table cellpadding="1" class="table table-bordered">
				<tr>
					<td>图片编号:</td>
					<td><s:textfield name="picture._picturePageID"
							class="comments" readonly="true" /></td>
				</tr>
				<tr>
					<td>图片标题:</td>
					<td><s:textfield name="picture._title" class="comments"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>作&nbsp;&nbsp;者:</td>
					<td><s:textfield name="picture._author" class="comments"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>日&nbsp;&nbsp;期:</td>
					<td><s:textfield name="picture._date" class="comments"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>图片uri:</td>
					<td><s:textfield id="_imageSrc" name="picture._imageSrc"
							class="comments" readonly="true" /></td>
				</tr>
				<tr>
					<td>阅读量:</td>
					<td><s:textfield name="picture._readCount" class="comments"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>点赞量:</td>
					<td><s:textfield name="picture._likeCount" class="comments"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>作者介绍:</td>
					<td><s:textarea name="picture._authorIntro" class="comments"
							readonly="true" rows="4" /></td>
				</tr>
				<tr>
					<td>图片文字:</td>
					<td><s:textarea name="picture._text" class="comments"
							readonly="true" rows="20" /></td>
				</tr>
				<tr>
					<td><a href="picture_list.action" class="easyui-linkbutton">返回</a></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>