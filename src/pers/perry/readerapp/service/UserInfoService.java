package pers.perry.readerapp.service;

import pers.perry.readerapp.bean.UserInfo;
import pers.perry.readerapp.dao.UserInfoDao;
import pers.perry.readerapp.dao.impl.UserInfoDaoImpl;
import pers.perry.readerapp.util.StringUtil;

public class UserInfoService {

	private UserInfoDao dao;

	public UserInfoService() {
		dao = new UserInfoDaoImpl();
	}

	public UserInfo findUserInfo(UserInfo userinfo) {
		String username = StringUtil.getMD5(userinfo.get_username().getBytes());
		String password = StringUtil.getMD5(userinfo.get_password().getBytes());
		UserInfo user = dao.findUserInfo(username, password);
		if (null != user) {
			user.set_username(userinfo.get_username());
		}
		return user;
	}

	public boolean update(UserInfo userinfo) {
		// 把用户名加密后,保存到数据库
		String username = StringUtil.getMD5(userinfo.get_username().getBytes());
		userinfo.set_username(username);
		return dao.update(userinfo);
	}

	public boolean checkData(String newpassword01, String newpassword02) {
		if ("".equals(newpassword01) || "".equals(newpassword02)) {
			return false;
		}
		if (!newpassword01.equals(newpassword02)) {
			return false;
		}
		return true;
	}

}
