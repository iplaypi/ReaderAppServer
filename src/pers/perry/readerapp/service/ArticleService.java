package pers.perry.readerapp.service;

import java.util.List;

import org.junit.Test;

import pers.perry.readerapp.base.DaoSupport;
import pers.perry.readerapp.bean.Article;
import pers.perry.readerapp.dao.ArticleDao;
import pers.perry.readerapp.dao.impl.ArticleDaoImpl;

public class ArticleService implements DaoSupport<Article> {

	private ArticleDao dao;

	public ArticleService() {
		dao = new ArticleDaoImpl();
	}

	@Override
	public List<Article> findAll() {
		return dao.findAll();
	}

	@Override
	public Article getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Article> getByIds(Integer[] ids) {
		return dao.getByIds(ids);
	}

	@Override
	public Integer getMaxId() {
		return dao.getMaxId();
	}

	@Override
	public boolean save(Article entity) {
		return dao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		return dao.delete(id);
	}

	@Override
	public boolean update(Article entity) {
		return dao.update(entity);
	}

	@Test
	public void testHib() {
		Article article = dao.getById(11);
		for (int i = 1; i < 11; i++) {
			article.set_id(i);
			article.set_title(null);
			article.set_articlePageID(i);
			dao.update(article);
		}
	}

}
