package day5;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

public class LinkedHashMapexp {

	public static void main(String[] args) {
		
		LinkedHashMap<String,Integer> marks= new LinkedHashMap<>();
		marks.put("English",10);
		marks.put("Maths",20);
		marks.put("kannada", 30);
		System.out.print("Details of sub and marks");
		Iterator<String> it=marks.keySet().iterator();
		
//		while(iterator.hashNext()) {
//			String str=iterator.next();
//			System.out.println(str + "===>" + marks.get(str));
//		}
		
		Set<Entry<String,Integer>> entrySet=marks.entrySet();
		for(Entry<String,Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "===>" + entry.getValue());
		}
	}

}
