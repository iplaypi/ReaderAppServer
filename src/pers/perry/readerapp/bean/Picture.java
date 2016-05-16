package pers.perry.readerapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "picture")
public class Picture {

	private Integer _id;
	private Integer _picturePageID;
	private String _title;
	private String _text;
	private String _author;
	private String _authorIntro;
	private String _date;
	private Integer _readCount;
	private String _imageSrc;
	private Integer _likeCount;

	public Picture() {
	}

	public Picture(Integer _id, Integer _picturePageID, String _title,
			String _text, String _author, String _authorIntro, String _date,
			Integer _readCount, String _imageSrc, Integer _likeCount) {
		super();
		this._id = _id;
		this._picturePageID = _picturePageID;
		this._title = _title;
		this._text = _text;
		this._author = _author;
		this._authorIntro = _authorIntro;
		this._date = _date;
		this._readCount = _readCount;
		this._imageSrc = _imageSrc;
		this._likeCount = _likeCount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer get_picturePageID() {
		return _picturePageID;
	}

	public void set_picturePageID(Integer _picturePageID) {
		this._picturePageID = _picturePageID;
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

	public String get_imageSrc() {
		return _imageSrc;
	}

	public void set_imageSrc(String _imageSrc) {
		this._imageSrc = _imageSrc;
	}

	public Integer get_likeCount() {
		return _likeCount;
	}

	public void set_likeCount(Integer _likeCount) {
		this._likeCount = _likeCount;
	}

}
