package com.ssafy.java.DOM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {

	private static WeatherDAO mgr = new WeatherDAO();
	List<Weather> list;
	
	// 싱글톤
	public static WeatherDAO getInstance() {
		return mgr;
	}
	
	// 싱글톤을 위한 생성자 제한 
	private WeatherDAO() {}

	public List<Weather> getWeatherList(){
		connectXML();
		return list;
	}
	
	public void connectXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		list = new ArrayList<Weather>();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4127352500").openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("data");
			
			for (int i=0;i<items.getLength();i++){
				Weather weather = new Weather();
				Node item = items.item(i);
				
				NodeList properties = item.getChildNodes();
				for (int j=0;j<properties.getLength();j++){
					Node property = properties.item(j);
					String name = property.getNodeName();
					if (name.equalsIgnoreCase("hour")){
						weather.setHour(Integer.parseInt(property.getFirstChild().getNodeValue()));
					} else if (name.equalsIgnoreCase("temp")){
						weather.setTemp(Double.parseDouble(property.getFirstChild().getNodeValue()));
					} else if (name.equalsIgnoreCase("WfKor")){
						weather.setWfKor(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("reh")){
						weather.setReh(Integer.parseInt(property.getFirstChild().getNodeValue()));
					}					
					
				}
				list.add(weather);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}//end connectXML method
}
