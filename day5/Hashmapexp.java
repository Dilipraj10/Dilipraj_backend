package day5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Hashmapexp {

	public static void main(String[] args) {

		HashMap<String,Integer> marks= new HashMap<String,Integer>();
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
