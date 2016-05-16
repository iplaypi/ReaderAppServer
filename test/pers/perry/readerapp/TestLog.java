package pers.perry.readerapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import pers.perry.readerapp.bean.Home;
import pers.perry.readerapp.dao.HomeDao;
import pers.perry.readerapp.dao.impl.HomeDaoImpl;

public class TestLog {

	// private ApplicationContext ac = new
	// ClassPathXmlApplicationContext("beans.xml");
	private Log log = LogFactory.getLog(this.getClass());

	@Test
	public void testLog() {
		log.debug("这是调试信息");
		log.info("这是基本信息");
		log.warn("这是警告信息");
		log.error("这是错误信息");
		log.fatal("这是严重错误信息");
	}

/*	 @Test
	 public void testMysqlHome() {
		 int i = 4;
	 HomeDao dao = new HomeDaoImpl();
	 Home entity = dao.getById(3);
	 System.out.println("get pageId: " + entity.get_homePageID());
	
	 while (i < 15) {
			entity.set_homePageID(i);
			dao.save(entity);
			System.out.println("insert one home.pageId: " + i);
			i++;
		}
	 
	 entity.set_id(4);
	 entity.set_homePageID(4);
	 dao.save(entity);
	 }*/

	// @Test
	// public void testMysqlArticle() {
	// ArticleDao dao = new ArticleDaoImpl();
	// Article entity = dao.getById(1);
	// System.out.println("get: " + entity.get_title());
	//
	// entity.set_id(7);
	// entity.set_articlePageID(7);
	// dao.save(entity);
	// }

/*	@Test
	public void testMysqlPicture() {
		int i = 4;
		PictureDao dao = new PictureDaoImpl();
		Picture entity = dao.getById(3);
		entity.set_authorIntro("@刘鹏飞:xxx");
		dao.update(entity);
		System.out.println("get: " + entity.get_picturePageID());
		while (i < 14) {
			entity.set_picturePageID(i);
			dao.save(entity);
			System.out.println("insert one picture.pageId: " + i);
			i++;
		}
	}*/
}
