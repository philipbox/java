package com.ssafy.java;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	private static NewsDAOSAXImpl mgr = new NewsDAOSAXImpl();
	private List<News> list = new ArrayList<News>();
	private News n;
	
	public static NewsDAOSAXImpl getInstance() {
		return mgr;
	}

	//싱글톤을 위한 생성자 제한 
	private NewsDAOSAXImpl() {}
	
	
	@Override
	public News search(int index) {
		System.out.println("SAX parser");
		n = list.get(index);
		return n;
	}
	
	
	@Override
	public List<News> getNewsList(String url) {
		connectXML(url);
		return list;
	}
	
	public void connectXML(String url) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	
	public class MyHandler extends DefaultHandler{
		private StringBuilder sb;
		News ns;
		
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}
		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			super.endElement(uri, localName, name);
			if (this.ns != null){
				if (name.equalsIgnoreCase("title")){
					ns.setTitle(sb.toString().trim());
				} else if (name.equalsIgnoreCase("description")){
					ns.setDesc((sb.toString().trim()));
				} else if (name.equalsIgnoreCase("link")){
					sb.trimToSize();
					if(sb.length()>0)
						ns.setLink((sb.toString().trim()));
				} else if (name.equalsIgnoreCase("item")){
				     list.add(ns);
				}
			}
			sb.setLength(0);	
		}
		
		
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list = new ArrayList<News>();
			sb = new StringBuilder();
		}
		
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
		}
		
		@Override
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("item")){
				ns = new News();
			}
		}
	}// MyHandler 

}
