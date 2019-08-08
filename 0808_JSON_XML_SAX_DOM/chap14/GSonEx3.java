package edu.ssafy.chap14;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import edu.ssafy.chap13.Member;

public class GSonEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson(); 
		
		String jsonString = "[{'num':'lee','name':'Min','age':26,'addr':'Seoul'},"
							+ "{'num':'park','name':'park','age':27,'addr':'Seoul'},"
							+ "{'num':'kim','name':'kim','age':28,'addr':'Incheon'}]"; 
		// json object Array => object 
		Member[] array = gson.fromJson(jsonString, Member[].class); 
		List<Member> list = Arrays.asList(array);
		System.out.println(list.toString());
		
		//object Array => json Object Array
		
		String json = gson.toJson(list);
		System.out.println(json);
		
		
		
	}

}
