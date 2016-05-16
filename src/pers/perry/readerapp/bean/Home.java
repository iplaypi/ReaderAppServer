package pers.perry.readerapp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "home")
public class Home {

	private Integer _id;
	private Integer _homePageID;
	private String _title;
	private String _text;
	private String _author;
	private String _authorIntro;
	private String _date;
	private Integer _readCount;
	private String _imageSrc;
	private String _musicTitle;
	private String _musicAuthor;
	private String _musicImage;
	private String _musicURL;
	private Integer _likeCount;

	public Home() {

	}

	public Home(Integer _id, Integer _homePageID, String _title, String _text,
			String _author, String _authorIntro, String _date,
			Integer _readCount, String _imageSrc, String _musicTitle,
			String _musicAuthor, String _musicImage, String _musicURL,
			Integer _likeCount) {
		super();
		this._id = _id;
		this._homePageID = _homePageID;
		this._title = _title;
		this._text = _text;
		this._author = _author;
		this._authorIntro = _authorIntro;
		this._date = _date;
		this._readCount = _readCount;
		this._imageSrc = _imageSrc;
		this._musicTitle = _musicTitle;
		this._musicAuthor = _musicAuthor;
		this._musicImage = _musicImage;
		this._musicURL = _musicURL;
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

	public Integer get_homePageID() {
		return _homePageID;
	}

	public void set_homePageID(Integer _homePageID) {
		this._homePageID = _homePageID;
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

	public String get_musicTitle() {
		return _musicTitle;
	}

	public void set_musicTitle(String _musicTitle) {
		this._musicTitle = _musicTitle;
	}

	public String get_musicAuthor() {
		return _musicAuthor;
	}

	public void set_musicAuthor(String _musicAuthor) {
		this._musicAuthor = _musicAuthor;
	}

	public String get_musicImage() {
		return _musicImage;
	}

	public void set_musicImage(String _musicImage) {
		this._musicImage = _musicImage;
	}

	public String get_musicURL() {
		return _musicURL;
	}

	public void set_musicURL(String _musicURL) {
		this._musicURL = _musicURL;
	}

	public Integer get_likeCount() {
		return _likeCount;
	}

	public void set_likeCount(Integer _likeCount) {
		this._likeCount = _likeCount;
	}

}
