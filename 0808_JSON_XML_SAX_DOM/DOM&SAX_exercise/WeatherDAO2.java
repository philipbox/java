package com.ssafy.java.DOM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class WeatherDAO2 {
	
	private static WeatherDAO2 mgr = new WeatherDAO2();
	List<Weather> list ;
	
	//싱글톤
	public static WeatherDAO2 getInstance() {
		return mgr;
	}

	//싱글톤을 위한 생성자 제한
	private WeatherDAO2() {}
	
	public List<Weather> getWeatherList(){
		connectXML();
		return list;
	}
	
	public void connectXML() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4127352500").openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		
	}
	
	//디폴트핸들러는 진짜 파서가 받고싶어하는 핸들러.
		public class MyHandler extends DefaultHandler{
			private StringBuilder sb;
			Weather wt;
			
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
				if (this.wt != null){
					if (name.equalsIgnoreCase("hour")){
						wt.setHour(Integer.parseInt(sb.toString().trim()));
					} else if (name.equalsIgnoreCase("temp")){
						wt.setTemp(Double.parseDouble(sb.toString().trim()));
					} else if (name.equalsIgnoreCase("wfKor")){
						wt.setWfKor(sb.toString().trim());
					} else if (name.equalsIgnoreCase("reh")){
						sb.trimToSize();
						if(sb.length()>0)
							wt.setReh(Integer.parseInt(sb.toString().trim()));
					} else if (name.equalsIgnoreCase("data")){
					     list.add(wt);
					}
				}
				sb.setLength(0);	
			}
			
			
			//문서가 시작될때.
			@Override
			public void startDocument() throws SAXException {
				super.startDocument();
				list = new ArrayList<Weather>();
				sb = new StringBuilder();
			}
			
			//문서가 끝날 때, 이벤트 발생. 콜백으로! ( 내가 호출하는게 아니라 파서가 호출 )
			@Override
			public void endDocument() throws SAXException {
				super.endDocument();
			}
			
			@Override
			public void startElement(String uri, String localName, String name,
					Attributes attributes) throws SAXException {
				super.startElement(uri, localName, name, attributes);
				if (name.equalsIgnoreCase("data")){
					wt = new Weather();
				}
			}
		}// MyHandler 
}
