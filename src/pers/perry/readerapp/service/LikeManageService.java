package pers.perry.readerapp.service;

import pers.perry.readerapp.bean.Article;
import pers.perry.readerapp.bean.Home;
import pers.perry.readerapp.bean.Picture;
import pers.perry.readerapp.dao.ArticleDao;
import pers.perry.readerapp.dao.HomeDao;
import pers.perry.readerapp.dao.PictureDao;
import pers.perry.readerapp.dao.impl.ArticleDaoImpl;
import pers.perry.readerapp.dao.impl.HomeDaoImpl;
import pers.perry.readerapp.dao.impl.PictureDaoImpl;

public class LikeManageService {

	private HomeDao homeDao;
	private ArticleDao articleDao;
	private PictureDao pictureDao;

	public LikeManageService() {
		this.homeDao = new HomeDaoImpl();
		this.articleDao = new ArticleDaoImpl();
		this.pictureDao = new PictureDaoImpl();
	}

	/**
	 * 根据不同的frament去不同的表中,根据id查询
	 * 
	 * @param fragment
	 * @param pageId
	 * @return
	 */
	public Integer getLikeCount(String fragment, Integer pageId) {
		Integer likeCount = 0;
		switch (fragment) {
		case "homePage":
			likeCount = homeDao.getById(pageId).get_likeCount();
			break;

		case "articlePage":
			likeCount = articleDao.getById(pageId).get_likeCount();
			break;

		case "picturePage":
			likeCount = pictureDao.getById(pageId).get_likeCount();
			break;

		default:
			break;
		}
		return likeCount;
	}

	public Integer updateLikeCount(String fragment, Integer pageId, Integer num) {
		Integer update = 0;
		switch (fragment) {
		case "homePage":
			Home home = homeDao.getById(pageId);
			// 更改点赞数量(+1 -1)
			home.set_likeCount(home.get_likeCount() + num);
			homeDao.update(home);
			update++;
			break;

		case "articlePage":
			Article article = articleDao.getById(pageId);
			// 更改点赞数量(+1 -1)
			article.set_likeCount(article.get_likeCount() + num);
			articleDao.update(article);
			update++;
			break;

		case "picturePage":
			Picture picture = pictureDao.getById(pageId);
			picture.set_likeCount(picture.get_likeCount() + num);
			pictureDao.update(picture);
			update++;
			break;

		default:
			break;
		}
		return update;
	}

}
