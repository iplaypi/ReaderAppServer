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
<title>添加首页</title>

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
		// 首先把可能存在的"成功信息"去除掉,"失败信息"去除掉
		document.getElementById("addSUCCESS").innerHTML = "";
		document.getElementById("addERROR").innerHTML = "";

		if (checkValueError("_homePageID", 9, "addERROR",
				"提交失败: 首页编号不能为空,不能超过9个字符.")) {
			return false;
		}
		if (!isNum("_homePageID", 1, 9)) {
			setValue("addERROR", "提交失败: 首页编号必须是1-9位的数字.");
			document.getElementById("_homePageID").focus();
			return false;
		}
		if (checkValueError("_title", 100, "addERROR",
				"提交失败: 首页标题不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_author", 100, "addERROR",
				"提交失败: 作者不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_date", 100, "addERROR",
				"提交失败: 日期不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_imageSrc", 100, "addERROR",
				"提交失败: 图片uri不能为空,不能超过100个字符.")) {
			return false;
		}

		if (checkValueError("_musicTitle", 100, "addERROR",
				"提交失败: 音乐标题不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_musicAuthor", 100, "addERROR",
				"提交失败: 音乐作者不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_musicImage", 100, "addERROR",
				"提交失败: 音乐图标uri不能为空,不能超过100个字符.")) {
			return false;
		}
		if (checkValueError("_musicURL", 100, "addERROR",
				"提交失败: 音乐文件uri不能为空,不能超过100个字符.")) {
			return false;
		}

		if (checkValueError("_authorIntro", 1200, "addERROR",
				"提交失败: 作者介绍不能为空,不能超过120个字符.")) {
			return false;
		}
		if (checkValueError("_text", 8000, "addERROR",
				"提交失败: 首页文字不能为空,不能超过8000个字符.")) {
			return false;
		}
		return true;
	}
	function submitForm() {
		if (validate()) {
			document.getElementById("addform").submit();
		} else {
		}
	}
</script>
</head>
<body style="margin: 5px;">

	<div class="easyui-panel" title="添加首页" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">

			<s:form id="addform" action="home_add" method="post">
				<table cellpadding="1" class="table table-bordered">
					<tr>
						<td><p id="addSUCCESS" style="color: blue; font-size: 1.5em">
								${addSUCCESS }</p></td>
						<td><p id="addERROR" style="color: red; font-size: 1.5em">
								${addERROR }</p></td>
					</tr>
					<tr>
						<td></td>
						<td><p>
								<font size="4" color="blue">首页编号必须从最大的开始递增,不能随意指定.</font>
							</p></td>
					</tr>
					<tr>
						<td>首页编号:</td>
						<td><s:textfield id="_homePageID" name="home._homePageID"
								class="comments" /></td>
					</tr>
					<tr>
						<td>首页标题:</td>
						<td><s:textfield id="_title" name="home._title"
								class="comments" /></td>
					</tr>
					<tr>
						<td>作&nbsp;&nbsp;者:</td>
						<td><s:textfield id="_author" name="home._author"
								class="comments" /></td>
					</tr>
					<tr>
						<td>日&nbsp;&nbsp;期:</td>
						<td><s:textfield id="_date" name="home._date"
								class="comments" /></td>
					</tr>
					<tr>
						<td>图片uri:</td>
						<td><s:select id="_imageSrc" list="#imagesSrc"
								value="home._imageSrc" name="home._imageSrc" class="comments"></s:select></td>
					</tr>
					<tr>
						<td>阅读量:</td>
						<td><s:textfield id="_readCount" name="home._readCount"
								class="comments" readonly="true" value="0" /></td>
					</tr>
					<tr>
						<td>点赞量:</td>
						<td><s:textfield id="_likeCount" name="home._likeCount"
								class="comments" readonly="true" value="0" /></td>
					</tr>
					<tr>
						<td>音乐标题:</td>
						<td><s:textfield id="_musicTitle" name="home._musicTitle"
								class="comments" /></td>
					</tr>
					<tr>
						<td>音乐作者:</td>
						<td><s:textfield id="_musicAuthor" name="home._musicAuthor"
								class="comments" /></td>
					</tr>
					<tr>
						<td>音乐图标uri:</td>
						<td><s:select id="_musicImage" list="#musicImage"
								value="home._musicImage" name="home._musicImage"
								class="comments"></s:select></td>
					</tr>
					<tr>
						<td>音乐文件uri:</td>
						<td><s:select id="_musicURL" list="#musicURL"
								value="home._musicURL" name="home._musicURL" class="comments" /></td>
					</tr>
					<tr>
						<td>作者介绍:</td>
						<td><s:textarea id="_authorIntro" name="home._authorIntro"
								class="comments" rows="4" /></td>
					</tr>
					<tr>
						<td>首页文字:</td>
						<td><s:textarea id="_text" name="home._text" class="comments"
								rows="20" /></td>
					</tr>
					<tr>
						<td><a href="javascript:submitForm()"
							class="easyui-linkbutton">提交</a></td>
						<td><a href="home_addUI.action" class="easyui-linkbutton">重置</a></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>

</body>
</html>