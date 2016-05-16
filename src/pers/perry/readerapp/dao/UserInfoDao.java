package pers.perry.readerapp.dao;

import pers.perry.readerapp.base.DaoSupport;
import pers.perry.readerapp.bean.UserInfo;

public interface UserInfoDao extends DaoSupport<UserInfo> {
	
	public UserInfo findUserInfo(String username, String password);

}
