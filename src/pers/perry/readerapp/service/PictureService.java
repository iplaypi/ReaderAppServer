package pers.perry.readerapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import pers.perry.readerapp.base.DaoSupport;
import pers.perry.readerapp.bean.Picture;
import pers.perry.readerapp.dao.PictureDao;
import pers.perry.readerapp.dao.impl.PictureDaoImpl;

public class PictureService implements DaoSupport<Picture> {

	private PictureDao dao;

	public PictureService() {
		this.dao = new PictureDaoImpl();
	}

	@Override
	public List<Picture> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Picture getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<Picture> getByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		return dao.getByIds(ids);
	}

	@Override
	public Integer getMaxId() {
		return dao.getMaxId();
	}

	@Override
	public boolean save(Picture entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public boolean update(Picture entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Test
	public void testHib() {
		Picture picture = dao.getById(11);
		for (int i = 1; i < 11; i++) {
			picture.set_id(i);
			picture.set_picturePageID(i);
			dao.update(picture);
		}
	}

}
