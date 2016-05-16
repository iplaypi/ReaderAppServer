package pers.perry.readerapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

//注解实体类
@Entity
@Table(name = "article")
public class Article {

	private Integer _id;
	private Integer _articlePageID;
	private String _title;
	private String _text;
	private String _author;
	private String _authorIntro;
	private String _date;
	private Integer _readCount;
	private Integer _likeCount;
	private String _comment;

	public Article() {
	}

	public Article(Integer _id, Integer _articlePageID, String _title,
			String _text, String _author, String _authorIntro, String _date,
			Integer _readCount, Integer _likeCount, String _comment) {
		super();
		this._id = _id;
		this._articlePageID = _articlePageID;
		this._title = _title;
		this._text = _text;
		this._author = _author;
		this._authorIntro = _authorIntro;
		this._date = _date;
		this._readCount = _readCount;
		this._likeCount = _likeCount;
		this._comment = _comment;
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

	public Integer get_articlePageID() {
		return _articlePageID;
	}

	public void set_articlePageID(Integer _articlePageID) {
		this._articlePageID = _articlePageID;
	}

	public String get_title() {
		return _title;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	@Type(type = "text")
	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}

	public String get_author() {
		return _author;
	}

	public void set_author(String _author) {
		this._author = _author;
	}

	public String get_authorIntro() {
		return _authorIntro;
	}

	public void set_authorIntro(String _authorIntro) {
		this._authorIntro = _authorIntro;
	}

	public String get_date() {
		return _date;
	}

	public void set_date(String _date) {
		this._date = _date;
	}

	public Integer get_readCount() {
		return _readCount;
	}

	public void set_readCount(Integer _readCount) {
		this._readCount = _readCount;
	}

	public Integer get_likeCount() {
		return _likeCount;
	}

	public void set_likeCount(Integer _likeCount) {
		this._likeCount = _likeCount;
	}

	public String get_comment() {
		return _comment;
	}

	public void set_comment(String _comment) {
		this._comment = _comment;
	}

}
