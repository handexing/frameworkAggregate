package org.jsoup.entity;

import java.util.Date;

/**
 * @ClassName: FlowerCategory
 * @Description: 花的品类
 * @author handx 908716835@qq.com
 * @date 2017年5月14日 下午2:20:33
 *
 */

public class FlowerCategory {

	private Integer id;
	private String name;
	private String url;
	private String imgPath;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public Integer getId() {
		return id;
	}

	public String getImgPath() {
		return imgPath;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FlowerCategory [id=" + id + ", name=" + name + ", url=" + url + ", imgPath=" + imgPath + ", createTime="
				+ createTime + "]";
	}

}
