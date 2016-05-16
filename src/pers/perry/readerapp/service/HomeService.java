package pers.perry.readerapp.service;

import java.util.List;

import org.junit.Test;

import pers.perry.readerapp.base.DaoSupport;
import pers.perry.readerapp.bean.Home;
import pers.perry.readerapp.bean.Picture;
import pers.perry.readerapp.dao.HomeDao;
import pers.perry.readerapp.dao.impl.HomeDaoImpl;

public class HomeService implements DaoSupport<Home> {

	private HomeDao dao;

	public HomeService() {
		this.dao = new HomeDaoImpl();
	}

	@Override
	public List<Home> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Home getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public List<Home> getByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		return dao.getByIds(ids);
	}

	@Override
	public Integer getMaxId() {
		return dao.getMaxId();
	}

	@Override
	public boolean save(Home entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public boolean update(Home entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Test
	public void testHib() {
		Home home = dao.getById(10);
		for (int i = 1; i < 10; i++) {
			home.set_id(i);
			home.set_homePageID(i);
			dao.update(home);
		}
	}

}
