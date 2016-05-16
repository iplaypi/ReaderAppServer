package pers.perry.readerapp.bean;

public class MaxId {

	private String homePageMaxId;
	private String articlePageMaxId;
	private String picturePageMaxId;

	public MaxId() {

	}

	public MaxId(String homePageMaxId, String articlePageMaxId, 
			String picturePageMaxId) {
		super();
		this.homePageMaxId = homePageMaxId;
		this.articlePageMaxId = articlePageMaxId;
		this.picturePageMaxId = picturePageMaxId;
	}

	public String getArticlePageMaxId() {
		return articlePageMaxId;
	}

	public void setArticlePageMaxId(String articlePageMaxId) {
		this.articlePageMaxId = articlePageMaxId;
	}

	public String getHomePageMaxId() {
		return homePageMaxId;
	}

	public void setHomePageMaxId(String homePageMaxId) {
		this.homePageMaxId = homePageMaxId;
	}

	public String getPicturePageMaxId() {
		return picturePageMaxId;
	}

	public void setPicturePageMaxId(String picturePageMaxId) {
		this.picturePageMaxId = picturePageMaxId;
	}

}
