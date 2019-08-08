package com.ssafy.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewsMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// DOM Parser
//		NewsDAODOMImpl ns = NewsDAODOMImpl.getInstance();
		
		// SAX Parser
		NewsDAOSAXImpl ns = NewsDAOSAXImpl.getInstance();
		
		
		
		List<News> news = new ArrayList<News>();
		news = ns.getNewsList("http://rss.etnews.com/Section902.xml");
		
		while(true) {
			System.out.println("========= News List ==========");
			for(int i=0; i<news.size(); i++) {
				System.out.println((i+1)+". "+news.get(i).getTitle());
			}
			System.err.println("News 번호 입력");
			int num = sc.nextInt();
			if(num==0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.println(ns.search(num-1));
			System.out.println("Link : " + ns.search(num-1).getLink());
			System.out.println();
			
			
		}
		
	}
}
