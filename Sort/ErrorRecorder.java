package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorRecorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> errorList = new ArrayList<String>();
		Map<String, Integer> file2Num = new HashMap<String, Integer>();
		
		while(sc.hasNext()){
			String path = sc.next();
			countErrors(path, file2Num);
		}
		
		sc.close();
		
		//Sort HashMap by value
		Map<String, Integer> sortedMap = sortByValues(file2Num);
		
		for(Map.Entry<String, Integer> e:sortedMap.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
		
	}
	
	public static void countErrors(String path, Map<String, Integer> file2Num){

			String[] splited = path.split("\\\\");
			String file = splited[splited.length-1];
			
			if(!file2Num.containsKey(file)){
				file2Num.put(file, 1);
			}else{
				file2Num.put(file, file2Num.get(file)+1);
			}
			
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private static Map<String, Integer> sortByValues(Map<String, Integer> Map) { 
        List list = new LinkedList(Map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
            	//Descending order
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        return sortedHashMap;
	}

}
