package pers.perry.readerapp.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.service.LikeManageService;

import com.opensymphony.xwork2.ActionSupport;

public class LikeManageAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(LikeManageAction.class);
	private LikeManageService service;
	private Map<String, Integer> map;
	private String fragmentName;
	private Integer pageId;
	private Integer num;

	public LikeManageAction() {
		service = new LikeManageService();
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public String getFragmentName() {
		return fragmentName;
	}

	public void setFragmentName(String fragmentName) {
		this.fragmentName = fragmentName;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String byIdJson() {
		log.info("byIdJson IP: " + getRemoteIP());
		map = new HashMap<String, Integer>();
		Integer likeCount = service.getLikeCount(fragmentName, pageId);
		map.put("count", likeCount);
		return SUCCESS;
	}

	public String updateByIdJson() {
		log.info("updateByIdJson IP: " + getRemoteIP());
		map = new HashMap<String, Integer>();
		map.put("update", 0);
		// 更新完成后返回行数1
		Integer likeCount = service.updateLikeCount(fragmentName, pageId, num);
		map.put("update", likeCount);
		return SUCCESS;
	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
