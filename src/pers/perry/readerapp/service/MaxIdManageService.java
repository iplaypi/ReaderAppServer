package pers.perry.readerapp.service;

import pers.perry.readerapp.bean.MaxId;
import pers.perry.readerapp.dao.ArticleDao;
import pers.perry.readerapp.dao.HomeDao;
import pers.perry.readerapp.dao.PictureDao;
import pers.perry.readerapp.dao.impl.ArticleDaoImpl;
import pers.perry.readerapp.dao.impl.HomeDaoImpl;
import pers.perry.readerapp.dao.impl.PictureDaoImpl;

public class MaxIdManageService {

	private HomeDao homeDao;
	private ArticleDao articleDao;
	private PictureDao pictureDao;

	public MaxIdManageService() {
		this.homeDao = new HomeDaoImpl();
		this.articleDao = new ArticleDaoImpl();
		this.pictureDao = new PictureDaoImpl();
	}

	public MaxId getMaxIds() {
		String homeId = homeDao.getMaxId() + "";
		String articleId = articleDao.getMaxId() + "";
		String pictureId = pictureDao.getMaxId() + "";
		MaxId maxId = new MaxId(homeId, articleId, pictureId);
		return maxId;
	}

}
