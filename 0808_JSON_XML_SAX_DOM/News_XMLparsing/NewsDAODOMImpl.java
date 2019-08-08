package com.ssafy.java;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {

	private static NewsDAODOMImpl mgr = new NewsDAODOMImpl();
	private List<News> list = new ArrayList<News>();
	
	//singleton
	public static NewsDAODOMImpl getInstance() {
		return mgr;
	}
	
	
	// 생성자 제한 
	private NewsDAODOMImpl() {}

	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return list;
	}
	
	@Override
	public News search(int index) {
		return list.get(index);
	}
	
	
	private void connectNews(String url) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		list = new ArrayList<News>();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			
			for (int i=0;i<items.getLength();i++){
				News news = new News();
				Node item = items.item(i);
				
				NodeList properties = item.getChildNodes();
				for (int j=0;j<properties.getLength();j++){
					Node property = properties.item(j);
					String name = property.getNodeName();
					if (name.equalsIgnoreCase("title")){
						news.setTitle(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("description")){
						news.setDesc(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("link")){
						news.setLink(property.getFirstChild().getNodeValue());
					} 
					
				}
				list.add(news);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
	
}
