package pers.perry.readerapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//注解实体类
@Entity
@Table(name = "userinfo")
public class UserInfo {

	private Integer _id;
	private String _username;
	private String _password;
	private String _info;

	public UserInfo() {
	}

	public UserInfo(Integer _id, String _username, String _password,
			String _info) {
		super();
		this._id = _id;
		this._username = _username;
		this._password = _password;
		this._info = _info;
	}

	// 注解主键、自增长
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String get_username() {
		return _username;
	}

	public void set_username(String _username) {
		this._username = _username;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public String get_info() {
		return _info;
	}

	public void set_info(String _info) {
		this._info = _info;
	}

}
