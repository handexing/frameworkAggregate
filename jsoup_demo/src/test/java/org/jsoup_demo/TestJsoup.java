package org.jsoup_demo;

import org.jsoup.Jsoup;
import org.jsoup.entity.Flower;
import org.jsoup.entity.FlowerCategory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestJsoup {

	private static List<FlowerCategory> getCategoryList() {

		List<FlowerCategory> categories = new ArrayList<FlowerCategory>();

		try {
			Document doc = Jsoup.connect("http://www.aihuhua.com/baike/").get();
			Elements catelist = doc.getElementsByClass("catelist");
			Element cates = catelist.first();
			List<Node> childNodes = cates.childNodes();
			for (int i = 0; i < childNodes.size(); i++) {
				Node node = childNodes.get(i);
				List<Node> childs = node.childNodes();
				if (childs != null && childs.size() > 0) {
					FlowerCategory category = new FlowerCategory();
					for (int j = 0; j < childs.size(); j++) {
						Node child = childs.get(j);
						if ("a".equals(child.nodeName())) {
							category.setUrl(child.attr("href"));
							category.setImgPath(child.childNode(1).attr("src"));
						} else if ("h2".equals(child.nodeName())) {
							category.setName(child.attr("title"));
						}
					}
					categories.add(category);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return categories;
	}

	private static List<String> getFlowerList(List<FlowerCategory> categoryList) {

		List<String> flowers = new ArrayList<String>();

		long startTime = System.currentTimeMillis(); // 获取开始时间

		for (FlowerCategory cates : categoryList) {
			System.out.println("正在爬取....路径为：" + cates.getUrl());

			try {
				Document doc = Jsoup.connect(cates.getUrl()).get();
				Elements elementsByClass = doc.getElementsByClass("cate_list");

				// 要给【FlowerCategory】修改，添加简介说明
				String cateName = elementsByClass.select("h1").text();
				// System.out.println("简介：" +
				// elementsByClass.select(".cont").text());

				Elements firstList = elementsByClass.select(".list");
				Elements elements = firstList.select("li");
				for (Element element : elements) {
					flowers.add(element.select("a").attr("href"));
				}

				System.out.println("获取成功，正在解析类别为【" + cateName + "】");

				// 如果有分页，循环解析
				int isPagination = elementsByClass.select(".pagination a").size();
				if (isPagination > 0) {

					String paginationText = elementsByClass.select(".pagination a")
							.eq(elementsByClass.select(".pagination a").size() - 2).text();

					int paginationTotal;
					if (isPagination >= 7) {
						paginationTotal = Integer.parseInt(paginationText.substring(2, paginationText.length()));
					} else {
						paginationTotal = Integer.parseInt(paginationText);
					}

					String urlCate = elementsByClass.select(".pagination a").eq(1).attr("href").split("/")[2];

					List<String> urls = new ArrayList<String>();

					System.out.println("开始解析分页路径....");
					for (int i = 1; i < paginationTotal; i++) {
						String url = "http://www.aihuhua.com/baike/" + urlCate + "/page-" + i + ".html";
						urls.add(url);
					}

					System.out.println("路径解析完毕，共" + paginationTotal + "页,开始爬取...");

					for (String url : urls) {

						doc = Jsoup.connect(url).get();
						elementsByClass = doc.getElementsByClass("cate_list");
						firstList = elementsByClass.select(".list");
						elements = firstList.select("li");
						for (Element element : elements) {
							flowers.add(element.select("a").attr("href"));
						}
					}

					System.out.println(cateName + "类别解析完毕！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("解析完毕，共解析花朵：" + flowers.size() + "条。" + "运行时间：" + (endTime - startTime));

		return flowers;
	}

	public static void main(String[] args) throws InterruptedException {

		// long startTime = System.currentTimeMillis(); // 获取开始时间
		//
		// System.out.println("开始爬取类别....");
		// List<FlowerCategory> categoryList = getCategoryList();
		// long endTime = System.currentTimeMillis(); // 获取结束时间
		// System.out.println("类别爬取完毕....爬取时间：" + (endTime - startTime));
		//
		// List<String> flowerList = getFlowerList(categoryList);

		List<Flower> Flowers = new ArrayList<Flower>();
		try {
			// for (String url : flowerList) {

			System.out.println("开始爬取花朵详细信息...");
			Document doc = Jsoup.connect("http://www.aihuhua.com/huahui/juandanbaihe.html").get();
			Element contDoc = doc.getElementsByClass("cont").first();

			Flower flower = new Flower();

			String name = contDoc.getElementsByClass("name").attr("title");
			System.out.println(name);

			flower.setImgPath(doc.getElementsByClass("img").select("img").attr("src"));
			flower.setName(name);
			flower.setEng(contDoc.getElementsByClass("eng").text());

			Elements labels = contDoc.getElementsByTag("label");
			flower.setNick(labels.get(0).text());
			flower.setType(labels.get(1).text());
			flower.setGenus(labels.get(2).text());
			flower.setBlooming(labels.get(3).text());

			// for (Element label : labels) {
			// System.err.println(label.text());
			// }

			Elements sideList = doc.getElementById("sideBox_listbox").getElementsByTag("a");

			Map<String, String> catalogs = new HashMap<String, String>();

			for (Element element : sideList) {
				String title = element.attr("title");
				String catalogId = element.attr("href");
				catalogs.put(title, catalogId.substring(1, catalogId.length()));
			}

			Iterator<String> iter = catalogs.keySet().iterator();
			while (iter.hasNext()) {
				String title = iter.next();
				String id = catalogs.get(title);

				Element element = doc.getElementById(id);
				title = title.substring(name.length(), title.length());
				// String selfTitle =
				// element.getElementsByTag("h3").attr("title");
				// selfTitle = selfTitle.substring(name.length(),
				// selfTitle.length());

				if ("介绍".equals(title)) {
					System.out.println(element);
				} else if ("形态特征".equals(title)) {

				} else if ("生态习性".equals(title)) {

				} else if ("栽培技术".equals(title)) {

				} else if ("繁殖方式".equals(title)) {

				} else if ("切花采收".equals(title)) {

				} else if ("病害防治".equals(title)) {

				} else if ("分布区域".equals(title)) {

				} else if ("食疗或药用价值".equals(title)) {

				} else if ("园林用途".equals(title)) {

				} else if ("作用用途".equals(title)) {

				} else if ("文化背景".equals(title)) {

				} else {

				}

			}

			System.err.println(flower);

			Flowers.add(flower);
			// }

			System.out.println("爬取完毕！共" + Flowers.size() + "朵花！");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
