package pers.perry.readerapp.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.bean.MaxId;
import pers.perry.readerapp.service.MaxIdManageService;

import com.opensymphony.xwork2.ActionSupport;

public class MaxIdManageAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(MaxIdManageAction.class);
	private MaxIdManageService service;
	private MaxId maxId;

	public MaxIdManageAction() {
		service = new MaxIdManageService();
	}

	public MaxId getMaxId() {
		return maxId;
	}

	public void setMaxId(MaxId maxId) {
		this.maxId = maxId;
	}

	public String maxIdsJson() {
		log.info("maxIdsJson IP: " + getRemoteIP());
		MaxId max = service.getMaxIds();
		this.setMaxId(max);
		return SUCCESS;
	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
