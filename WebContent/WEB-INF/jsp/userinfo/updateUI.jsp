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
<title>修改密码</title>

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

		// 首先把可能存在的"失败信息",成功信息去除掉
		document.getElementById("updateERROR").innerHTML = "";
		document.getElementById("updateSUCCESS").innerHTML = "";

		if (checkValueError("username", 10, "updateERROR",
				"提交失败: 用户名不能为空,不能超过10个字符.")) {
			return false;
		}

		if (checkValueError("password", 10, "updateERROR",
				"提交失败: 原密码不能为空,不能超过10个字符.")) {
			return false;
		}
		if (!isNum("password", 6, 10)) {
			setValue("updateERROR", "提交失败: 原密码必须是6-10位的数字.");
			document.getElementById("password").focus();
			return false;
		}

		if (checkValueError("newpassword01", 10, "updateERROR",
				"提交失败: 新密码不能为空,不能超过10个字符.")) {
			return false;
		}
		if (!isNum("newpassword01", 6, 10)) {
			setValue("updateERROR", "提交失败: 新密码必须是6-10位的数字.");
			document.getElementById("newpassword01").focus();
			return false;
		}

		if (checkValueError("newpassword02", 10, "updateERROR",
				"提交失败: 确认密码不能为空,不能超过10个字符.")) {
			return false;
		}
		if (!isNum("newpassword02", 6, 10)) {
			setValue("updateERROR", "提交失败: 确认密码必须是6-10位的数字.");
			document.getElementById("newpassword02").focus();
			return false;
		}

		if (getValue("newpassword01") != getValue("newpassword02")) {
			setValue("updateERROR", "提交失败: 两次密码不相等.");
			document.getElementById("newpassword01").focus();
			return false;
		}
		return true;
	}
	function submitForm() {
		if (validate()) {
			document.getElementById("updateform").submit();
		} else {
		}
	}
</script>
</head>
<body style="margin: 5px;">

	<div class="easyui-panel" title="修改密码" style="width: auto">
		<div style="padding: 10px 20px 10px 20px">

			<s:form id="updateform" action="login_update" method="post">
				<table cellpadding="2" class="table table-bordered">
					<tr>
						<td><p id="updateSUCCESS"
								style="color: blue; font-size: 1.5em">${updateSUCCESS }</p></td>
						<td><p id="updateERROR" style="color: red; font-size: 1.5em">
								${updateERROR }</p></td>
					</tr>
					<tr>
						<td>用&nbsp;户&nbsp;名:</td>
						<td><s:textfield id="username" name="username"
								class="comments" readonly="true" /></td>
					</tr>
					<tr>
						<td>原&nbsp;密&nbsp;码:</td>
						<td><s:textfield id="password" name="password"
								class="comments" /></td>
					</tr>
					<tr>
						<td></td>
						<td><p>
								<font color="red" size="4">密码必须是6-10位数字.</font>
							</p></td>
					</tr>
					<tr>
						<td>新&nbsp;密&nbsp;码:</td>
						<td><s:textfield id="newpassword01" name="newpassword01"
								class="comments" /></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><s:textfield id="newpassword02" name="newpassword02"
								class="comments" /></td>
					</tr>
					<tr>
						<td><a href="javascript:submitForm()"
							class="easyui-linkbutton">提交</a></td>
						<td><a href="login_updateUI.action" class="easyui-linkbutton">重置</a></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>

</body>
</html>