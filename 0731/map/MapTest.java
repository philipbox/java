package edu.ssafy.chpa07.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		
		// Map에는 2개의 제너릭타입.
		Map<Integer, String> m = new HashMap();
		m.put(1, "My");
		m.put(2, "Your");
		m.put(3, "Ours");
		System.out.println(m.get(2));
		
		Collection<String> values = m.values();
		for(String s : values) {
			System.out.println(s);
		}
		
System.out.println("--------------------------------------");
System.out.println("java5.0이상 최근방식");
		Set<Entry<Integer, String>> entrySet = m.entrySet();
		Set<Integer> keySet = m.keySet();
		for(Integer i : keySet) {
			System.out.println(m.get(i));
		}
		
System.out.println("--------------------------------------");
System.out.println("java5.0이전 예전방식");
		Iterator<Integer> iter = m.keySet().iterator();
		while(iter.hasNext()) {
			System.out.println(m.get(iter.next()));
		}
		
	}//end main
}
