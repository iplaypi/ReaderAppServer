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
<title>上传文件</title>

<!-- 进度条循环css -->
<link rel="stylesheet" href="<%=basePath%>CSS/style.css" media="screen"
	type="text/css" />

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
	function validate(id, dir) {
		// 首先把可能存在的"成功信息"去除掉,"失败信息"去除掉
		document.getElementById("addSUCCESS").innerHTML = "";
		document.getElementById("addERROR").innerHTML = "";

		// 验证文件类型是否正确
		if (validateFile(id, "addERROR", dir)) {
			return true;
		} else {
			return false;
		}
	}

	function submitForm() {
		if (validate("image", "dir")) {
			// 设置提交按钮连接隐藏,防止上传过程误触(重置按钮可以继续使用)
			document.getElementById("upload").style.visibility = "hidden";
			//显示进度条
			document.getElementById("caseBlanche").style.visibility = "visible";
			// 提交表单
			document.getElementById("addform").submit();
		} else {

		}
	}
</script>
</head>
<body style="margin: 5px;">

	<div class="easyui-panel" title="上传文件" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">
			<table cellpadding="1" class="table table-bordered">
				<tr>
					<td><p id="addSUCCESS" style="color: blue; font-size: 1.5em">
							${addSUCCESS }</p></td>
					<td><p id="addERROR" style="color: red; font-size: 1.5em">
							${addERROR }</p></td>
				</tr>
				<tr>
					<td><div id="caseBlanche">
							<div id="rond">
								<div id="point"></div>
							</div>
							<div id="load">
								<p>正在上传</p>
							</div>
						</div></td>
					<td><p>
							<font color="blue" size="4">图片(.jpg/.png/.bmp), 音乐(.mp3),
								文件大小(12M以内), 不能随意指定.</font>
						</p></td>
				</tr>
				<s:form id="addform" action="upload_add" method="post"
					enctype="multipart/form-data">
					<tr>
						<td>文件类型选择:</td>
						<td><s:select id="dir" list="#typeName" name="dir"
								class="comments"></s:select></td>
					</tr>
					<tr>
						<td>文件选择:</td>
						<td><s:file id="image" name="image"
								accept=".jpg,.png,.bmp,.mp3" class="comments"></s:file></td>
					</tr>
				</s:form>
				<tr>
					<td><a id="upload" href="javascript:submitForm()"
						class="easyui-linkbutton">上传</a></td>
					<td><a id="reset" href="upload_addUI.action"
						class="easyui-linkbutton">重置</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>