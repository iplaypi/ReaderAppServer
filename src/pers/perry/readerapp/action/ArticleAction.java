package pers.perry.readerapp.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.bean.Article;
import pers.perry.readerapp.service.ArticleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(ArticleAction.class);
	private ArticleService service;
	private Article article;
	private Integer _id;
	private Integer pageId;

	public ArticleAction() {
		service = new ArticleService();
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String byIdJson() {
		log.info("byIdJson IP: " + getRemoteIP());
		log.info("byIdJson.");
		article = service.getById(pageId);
		// 阅读量增加1
		article.set_readCount(article.get_readCount() + 1);
		service.update(article);
		return SUCCESS;
	}

	// 查询list
	public String list() {
		log.info("list IP: " + getRemoteIP());
		// 默认获取10条记录
		Integer maxId = service.getMaxId();
		Integer[] ids = new Integer[10];
		for (Integer id = maxId; id > maxId - 10; id--) {
			ids[id - maxId + 9] = id;
		}
		List<Article> list = service.getByIds(ids);
		// jsp中使用struts标签库获得数据
		ActionContext.getContext().put("list", list);
		return "list";
	}

	// 编辑
	public String editUI() {
		log.info("editUI IP: " + getRemoteIP());
		article = service.getById(_id);
		return "editUI";
	}

	public String edit() {
		log.info("edit IP: " + getRemoteIP());
		if (null != article) {
			if (!service.update(article)) {
				ActionContext.getContext().put("editERROR", "提交失败.请重试.");
				return "editUI";
			}
		}
		return "toList";
	}

	// 删除
	public String delete() {
		log.info("delete IP: " + getRemoteIP());
		service.delete(_id);
		return "toList";
	}

	// 查看更多
	public String infoUI() {
		log.info("infoUI IP: " + getRemoteIP());
		article = service.getById(_id);
		return "infoUI";
	}

	// 添加(页面)
	public String addUI() {
		log.info("addUI IP: " + getRemoteIP());
		return "addUI";
	}

	// 添加
	public String add() {
		log.info("add IP: " + getRemoteIP());
		if (null != article) {
			if (!service.save(article)) {
				ActionContext.getContext().put("addERROR", "添加失败.请重试.");
				return "addUI";
			}
		} else {
			ActionContext.getContext().put("addERROR", "对象为空,添加失败.请重试.");
			return "addUI";
		}
		// 把数据清空
		article = new Article();
		ActionContext.getContext().put("addSUCCESS", "添加成功.");
		return "addUI";
	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
