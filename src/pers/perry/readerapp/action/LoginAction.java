package pers.perry.readerapp.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.bean.UserInfo;
import pers.perry.readerapp.service.UserInfoService;
import pers.perry.readerapp.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(LoginAction.class);
	private UserInfoService service;
	private UserInfo userinfo;
	private String username;
	private String password;
	private String newpassword01;
	private String newpassword02;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getNewpassword01() {
		return newpassword01;
	}

	public void setNewpassword01(String newpassword01) {
		this.newpassword01 = newpassword01;
	}

	public String getNewpassword02() {
		return newpassword02;
	}

	public void setNewpassword02(String newpassword02) {
		this.newpassword02 = newpassword02;
	}

	public LoginAction() {
		service = new UserInfoService();
	}

	// 登录验证
	public String login() {
		log.info("login IP: " + getRemoteIP());
		if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
			ActionContext.getContext().put("error", "用户名或者密码不能为空.请重试.");
			return ERROR;
		}
		userinfo = service
				.findUserInfo(new UserInfo(0, username, password, ""));
		if (null == userinfo) {
			ActionContext.getContext().put("error", "用户名或者密码错误.请重试.");
			return ERROR;
		}
		if (null == ActionContext.getContext().getSession().get("currentUser")) {
			// 把登录信息保存在session中
			ActionContext.getContext().getSession()
					.put("currentUser", userinfo);
		}
		return SUCCESS;
	}

	// 跳转主界面
	public String main() {
		log.info("main, IP: " + getRemoteIP());
		return "main";
	}

	// 退出
	public String exit() {
		log.info("exit IP: " + getRemoteIP());
		// 把登录信息从session中移除
		ActionContext.getContext().getSession().remove("currentUser");
		return "exit";
	}

	// 查询个人信息
	public String infoUI() {
		log.info("infoUI IP: " + getRemoteIP());
		// 从session中获取个人信息,避免从数据库查询
		userinfo = (UserInfo) ActionContext.getContext().getSession()
				.get("currentUser");
		return "infoUI";
	}

	public String updateUI() {
		log.info("updateUI IP: " + getRemoteIP());
		userinfo = (UserInfo) ActionContext.getContext().getSession()
				.get("currentUser");
		if (null != userinfo) {
			username = userinfo.get_username();
		}
		return "updateUI";
	}

	// 更新成功或者失败,都转发到updateUI.jsp页面,并携带结果信息
	public String update() {
		// 日志输出密码
		log.info("update IP: " + newpassword01 + ", " + getRemoteIP());
		userinfo = (UserInfo) ActionContext.getContext().getSession()
				.get("currentUser");
		if (null != userinfo) {
			// 把原密码加密
			String temp = StringUtil.getMD5(password.getBytes());
			// 验证原密码是否正确
			if (!temp.equals(userinfo.get_password())) {
				ActionContext.getContext().put("updateERROR",
						"更新失败,原密码输入错误.请重试.");
				return "updateUI";
			} else {
				// 验证两次密码是否相等
				if (!service.checkData(newpassword01, newpassword02)) {
					ActionContext.getContext().put("updateERROR",
							"更新失败,两次密码不相等.请重试.");
					return "updateUI";
				} else {
					// 更改新密码(session也同时更改,传递的对象)
					userinfo.set_password(StringUtil.getMD5(newpassword01
							.getBytes()));
					// 保存到数据库
					if (service.update(userinfo)) {
						// service保存时将用户名加密了(传递的对象,值都有影响,包括session),所以要改回来
						userinfo.set_username(username);
						ActionContext.getContext().put("updateSUCCESS",
								"更新密码成功.");
						// 清空数据,转发到updateUI.jsp页面
						password = "";
						newpassword01 = "";
						newpassword02 = "";
						return "updateUI";
					} else {
						// session还要改回来
						userinfo.set_password(temp);
						ActionContext.getContext().put("updateERROR",
								"更新失败，请重试.");
						return "updateUI";
					}
				}
			}
		} else {
			ActionContext.getContext().put("updateERROR", "对象为空,更新失败.请重试.");
			return "updateUI";
		}

	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
