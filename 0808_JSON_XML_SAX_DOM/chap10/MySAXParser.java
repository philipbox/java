package edu.ssafy.chap10;

import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser {
	ArrayList<Check> list;

	public ArrayList<Check> getContent(String url){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	//디폴트핸들러는 진짜 파서가 받고싶어하는 핸들러.
	public class MyHandler extends DefaultHandler{
		private StringBuilder sb;
		Check ch;
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
			if (this.ch != null){
				if (name.equalsIgnoreCase("Clean")){
					ch.setClean(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Ready")){
					ch.setReady(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Response")){
					ch.setResponse(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Request")){
					sb.trimToSize();
					if(sb.length()>0)
						ch.setRequest(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Check")){
				     list.add(ch);
				}
				sb.setLength(0);	
			}
		}
		
		
		//문서가 시작될때.
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list = new ArrayList<Check>();
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
			if (name.equalsIgnoreCase("Check")){
				ch = new Check();
				ch.setCode(attributes.getValue(0));
				ch.setDate(attributes.getValue(1));
			}
	}
}
}