package org.jsoup.entity;

/**
 * @ClassName: Flower
 * @Description: 花实体类
 * @author handx 908716835@qq.com
 * @date 2017年5月14日 下午2:19:56
 *
 */

public class Flower {

	private Long id;
	private String name;
	private String url;
	private String imgPath;
	private String nick;
	private String eng;
	private String type;
	private String genus;
	private String blooming;

	public String getBlooming() {
		return blooming;
	}

	public String getEng() {
		return eng;
	}

	public String getGenus() {
		return genus;
	}

	public Long getId() {
		return id;
	}

	public String getImgPath() {
		return imgPath;
	}

	public String getName() {
		return name;
	}

	public String getNick() {
		return nick;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void setBlooming(String blooming) {
		this.blooming = blooming;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", url=" + url + ", imgPath=" + imgPath + ", nick=" + nick
				+ ", eng=" + eng + ", type=" + type + ", genus=" + genus + ", blooming=" + blooming + "]";
	}


}
