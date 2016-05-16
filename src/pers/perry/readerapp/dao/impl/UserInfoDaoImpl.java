package pers.perry.readerapp.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.junit.Test;

import pers.perry.readerapp.base.DaoSupportImpl;
import pers.perry.readerapp.bean.UserInfo;
import pers.perry.readerapp.dao.UserInfoDao;
import pers.perry.readerapp.util.DBHelper;

public class UserInfoDaoImpl extends DaoSupportImpl<UserInfo> implements
		UserInfoDao {

	private static final Log log = LogFactory.getLog(UserInfoDaoImpl.class);

	@Override
	public UserInfo findUserInfo(String username, String password) {
		UserInfo userinfo = null;
		try {
			session = DBHelper.getCurrentSession();
			String hql = "from UserInfo where _username=? and _password=?";
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
			userinfo = (UserInfo) query.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			session.close();
		}
		return userinfo;
	}

	@Test
	public void ceshi() {
		new UserInfoDaoImpl().findUserInfo("liupengfei", "123456");
	}

}
