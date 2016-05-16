package pers.perry.readerapp.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.action.ArticleAction;
import pers.perry.readerapp.bean.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器,验证登录信息(获取Json数据的方法不必拦截)
 * 
 * @author perry
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final Log log = LogFactory.getLog(LoginInterceptor.class);

	public LoginInterceptor() {
	}

	// 验证是否登录,查看session信息
	public String doIntercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext actionContext = invocation.getInvocationContext();
		// 从session中获取当前登录用户
		Map<String, Object> session = actionContext.getSession();
		UserInfo currentUser = (UserInfo) session.get("currentUser");

		if (null != currentUser) {
			// 用户已经登录,放弃拦截
			// 服务器关闭后重启,服务器session清除,客户端session没清除,放弃拦截,但要把session放在服务器
			// session.put("currentUser", currentUser);
			return invocation.invoke();
		}
		log.warn("doIntercept,not login, to login.jsp: " + getRemoteIP());
		// 还没有登录,实施拦截
		actionContext.put("error", "还没有登录.");
		return Action.LOGIN;
	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
