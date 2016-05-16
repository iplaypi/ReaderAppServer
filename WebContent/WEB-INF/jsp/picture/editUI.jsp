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
<title>编辑图片</title>
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
<script type="text/javascript" src="<%=basePath%>JS/checkValue.js"></script>
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
<script type="text/javascript">
	function validate() {

		// 首先把可能存在的"失败信息"去除掉
		document.getElementById("editERROR").innerHTML = "";

		if (checkValueError("_id", 9, "editERROR", "提交失败: 图片主键id不能为空,不能超过9个字符.")) {
			return false;
		}

		if (checkValueError("_picturePageID", 9, "editERROR",
				"提交失败: 图片编号不能为空,不能超过9个字符.")) {
			return false;
		}
		if (!isNum("_picturePageID", 1, 9)) {
			setValue("editERROR", "提交失败: 图片编号必须是1-9位的数字.");
			return false;
		}
		if (checkValueError("_title", 100, "editERROR",
				"提交失败: 图片标题不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_author", 100, "editERROR",
				"提交失败: 作者不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_date", 100, "editERROR",
				"提交失败: 日期不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_imageSrc", 100, "editERROR",
				"提交失败: 图片uri不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_readCount", 9, "editERROR",
				"提交失败: 阅读量不能为空,不能超过9个字符.")) {
			return false;
		}
		if (checkValueError("_likeCount", 9, "editERROR",
				"提交失败: 点赞量不能为空,不能超过9个字符.")) {
			return false;
		}
		if (checkValueError("_authorIntro", 1200, "editERROR",
				"提交失败: 作者介绍不能为空,不能超过120个字符.")) {
			return false;
		}
		if (checkValueError("_text", 8000, "editERROR",
				"提交失败: 图片文字不能为空,不能超过8000个字符.")) {
			return false;
		}
		return true;
	}
	function submitForm() {
		if (validate()) {
			document.getElementById("editform").submit();
		} else {
		}
	}
</script>
</head>
<body style="margin: 5px;">
	<div class="easyui-panel" title="编辑图片" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">

			<s:form id="editform" action="picture_edit" method="post">
				<table cellpadding="2" class="table table-bordered">
					<!-- hidden隐藏主键_id,更新的时候传回后台用到 -->
					<s:hidden id="_id" name="picture._id"></s:hidden>
					<tr>
						<td></td>
						<td><p id="editERROR" style="color: red; font-size: 1.5em">
								${editERROR }</p></td>
					</tr>
					<tr>
						<td>图片编号:</td>
						<td><s:textfield id="_picturePageID"
								name="picture._picturePageID" class="comments" readonly="true" /></td>
					</tr>
					<tr>
						<td>图片标题:</td>
						<td><s:textfield id="_title" name="picture._title"
								class="comments" /></td>
					</tr>
					<tr>
						<td>作&nbsp;&nbsp;者:</td>
						<td><s:textfield id="_author" name="picture._author"
								class="comments" /></td>
					</tr>
					<tr>
						<td>日&nbsp;&nbsp;期:</td>
						<td><s:textfield id="_date" name="picture._date"
								class="comments" /></td>
					</tr>
					<tr>
					<tr>
						<td>图片uri:</td>
						<td><s:select id="_imageSrc" list="#imagesSrc"
								value="picture._imageSrc" name="picture._imageSrc"
								class="comments" /></td>
					</tr>
					<tr>
						<td>阅读量:</td>
						<td><s:textfield id="_readCount" name="picture._readCount"
								class="comments" readonly="true" /></td>
					</tr>
					<tr>
						<td>点赞量:</td>
						<td><s:textfield id="_likeCount" name="picture._likeCount"
								class="comments" readonly="true" /></td>
					</tr>
					<tr>
						<td>作者介绍:</td>
						<td><s:textarea id="_authorIntro" name="picture._authorIntro"
								class="comments" rows="4" /></td>
					</tr>
					<tr>
						<td>图片文字:</td>
						<td><s:textarea id="_text" name="picture._text"
								class="comments" rows="20" /></td>
					</tr>
					<tr>
						<td><a href="javascript:submitForm()"
							class="easyui-linkbutton">提交</a></td>
						<td><a href="picture_list.action" class="easyui-linkbutton">返回</a></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>

</body>
</html>