package com.ssafy.java.DOM;

import java.util.List;

public class WeatherMain {
	public static void main(String[] args) {
		
		WeatherDAO mgr = WeatherDAO.getInstance();
		System.out.println("==================DOM=================");
		List<Weather> list = mgr.getWeatherList();
		for( Weather w : list) {
			System.out.println(w);
		}
		System.out.println("==================SAX=================");
		list.clear();
		WeatherDAO2 mgr2 = WeatherDAO2.getInstance();
		list = mgr2.getWeatherList();
		for( Weather w : list) {
				System.out.println(w);
		}
	}
}
