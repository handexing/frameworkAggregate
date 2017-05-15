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

	private String introduce;// 介绍
	private String morphological;// 形态特征
	private String ecologicalHabit;// 生态习性
	private String cultivationTechniques;// 栽培技术
	private String reproductiveMode;// 繁殖方式
	private String cutFlower;// 切花采收
	private String diseaseControl;// 病害防治
	private String distributionArea;// 分布区域
	private String foodTherapy;// 食疗或药用价值
	private String gardenUse;// 园林用途
	private String functionUse;// 作用用途
	private String culturalBackground;// 文化背景

	// 描述实在是太多了...

	public String getBlooming() {
		return blooming;
	}

	public String getCultivationTechniques() {
		return cultivationTechniques;
	}

	public String getCulturalBackground() {
		return culturalBackground;
	}

	public String getCutFlower() {
		return cutFlower;
	}

	public String getDiseaseControl() {
		return diseaseControl;
	}

	public String getDistributionArea() {
		return distributionArea;
	}

	public String getEcologicalHabit() {
		return ecologicalHabit;
	}

	public String getEng() {
		return eng;
	}

	public String getFoodTherapy() {
		return foodTherapy;
	}

	public String getFunctionUse() {
		return functionUse;
	}

	public String getGardenUse() {
		return gardenUse;
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

	public String getIntroduce() {
		return introduce;
	}

	public String getMorphological() {
		return morphological;
	}

	public String getName() {
		return name;
	}

	public String getNick() {
		return nick;
	}

	public String getReproductiveMode() {
		return reproductiveMode;
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

	public void setCultivationTechniques(String cultivationTechniques) {
		this.cultivationTechniques = cultivationTechniques;
	}

	public void setCulturalBackground(String culturalBackground) {
		this.culturalBackground = culturalBackground;
	}

	public void setCutFlower(String cutFlower) {
		this.cutFlower = cutFlower;
	}

	public void setDiseaseControl(String diseaseControl) {
		this.diseaseControl = diseaseControl;
	}

	public void setDistributionArea(String distributionArea) {
		this.distributionArea = distributionArea;
	}

	public void setEcologicalHabit(String ecologicalHabit) {
		this.ecologicalHabit = ecologicalHabit;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public void setFoodTherapy(String foodTherapy) {
		this.foodTherapy = foodTherapy;
	}

	public void setFunctionUse(String functionUse) {
		this.functionUse = functionUse;
	}

	public void setGardenUse(String gardenUse) {
		this.gardenUse = gardenUse;
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

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setMorphological(String morphological) {
		this.morphological = morphological;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setReproductiveMode(String reproductiveMode) {
		this.reproductiveMode = reproductiveMode;
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
