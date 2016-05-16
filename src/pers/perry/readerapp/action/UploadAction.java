package pers.perry.readerapp.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import pers.perry.readerapp.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 上传Action 主要是上传图片,音乐,查询文件列表
 * 
 * @author perry
 *
 */
public class UploadAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(UploadAction.class);
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	// 标记不同类型文件的路径
	private String dir;
	// 标记删除的文件路径
	private String uri;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public UploadAction() {
	}

	// 查询list
	public String list() {
		log.info("list IP: " + getRemoteIP());
		putMapToContext();
		return "list";
	}

	public String addUI() {
		log.info("addUI IP: " + getRemoteIP());
		// 把文件类型查询出来
		Map<String, String> typeName = StringUtil.loadTypeName();
		ActionContext.getContext().put("typeName", typeName);
		return "addUI";
	}

	public String add() {
		log.info("add IP: " + getRemoteIP());
		String realPath = ServletActionContext.getServletContext().getRealPath(
				dir);
		if (null != image) {
			// 文件格式不合法,或者文件格式与选择的文件类型不匹配
			if (!StringUtil.isMIME(imageFileName, dir)) {
				ActionContext.getContext().put("addERROR",
						"上传失败,选择的文件格式错误,或者文件格式与选择的文件类型不匹配,请重试.");
				// 把文件类型查询出来
				Map<String, String> typeName = StringUtil.loadTypeName();
				ActionContext.getContext().put("typeName", typeName);
				return "addUI";
			}
			File saveFile = new File(new File(realPath), imageFileName);
			if (!saveFile.getParentFile().exists()) {
				// 父目录不存在,则创建
				saveFile.getParentFile().mkdirs();
			}
			if (!saveFile.exists()) {
				try {
					FileUtils.copyFile(image, saveFile);
					ActionContext.getContext().put("addSUCCESS", "上传成功.");
				} catch (IOException e) {
					log.error("复制上传的文件出错: " + e.getStackTrace());
				}
			} else {
				ActionContext.getContext().put("addERROR", "上传失败,文件已存在.");
			}
		} else {
			ActionContext.getContext().put("addERROR", "上传失败,文件为空或者没选择文件.");
		}
		// 把文件类型查询出来
		Map<String, String> typeName = StringUtil.loadTypeName();
		ActionContext.getContext().put("typeName", typeName);
		return "addUI";
	}

	public String deleteUI() {
		log.info("deleteUI IP: " + getRemoteIP());
		// 把文件查询出来
		putMapToContext();
		return "deleteUI";
	}

	// 删除文件
	public String delete() {
		log.info("delete IP: " + getRemoteIP());
		if ("/".equals(uri)) {
			ActionContext.getContext().put("deleteERROR", "删除失败,选择的文件不正确.");
		} else {
			String realPath = ServletActionContext.getServletContext()
					.getRealPath(uri);
			File file = new File(realPath);
			if (file.exists()) {
				file.delete();
				ActionContext.getContext().put("deleteSUCCESS", "删除成功.");
			} else {
				ActionContext.getContext().put("deleteERROR", "删除失败,选择的文件不存在.");
			}
		}
		putMapToContext();
		return "deleteUI";
	}

	private void putMapToContext() {
		Map<String, String> homeImagesSrc = StringUtil.loadFileName(0);
		Map<String, String> musicImage = StringUtil.loadFileName(1);
		Map<String, String> musicURL = StringUtil.loadFileName(2);
		Map<String, String> pictureImagesSrc = StringUtil.loadFileName(3);
		ActionContext.getContext().put("homeImagesSrc", homeImagesSrc);
		ActionContext.getContext().put("musicImage", musicImage);
		ActionContext.getContext().put("musicURL", musicURL);
		ActionContext.getContext().put("pictureImagesSrc", pictureImagesSrc);
	}

	// 获取远程客户端IP地址
	private String getRemoteIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

}
