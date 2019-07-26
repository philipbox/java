package edu.ssafy.chap06;

public class StringTest02 {
	
	public static void main(String[] args) {
		
		String s = "String";
		String s2 = "String";
		String s3 = new String("String");
		String s4 = new String("String");
		
		StringBuilder sb = new StringBuilder(s);
		sb.append("얄루");
		System.out.println(sb.toString());
		
	}
}
