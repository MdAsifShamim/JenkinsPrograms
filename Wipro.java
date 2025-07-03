import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Wipro {

	public static void main(String[] args) {
		System.out.println("webhook");
		question1();
		question2();

	}
	
	public static void question1() {
		String para="i love you neha afreen baby";
		
		//Convert String to List of Character
		List<Character> charList=new String(para.replace(" ",""))
				.chars()
				.mapToObj(c->(char) c)
				.collect(Collectors.toCollection(ArrayList<Character>::new));
		
		//Get Only duplicate value and its number of occurance
		
		Map<Character,Long> finalMap=charList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.filter(entry->entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		//Sort Map into Based on Value first and then key
		
		 Map<Character, Long> sortedMap=finalMap.entrySet().stream()
		.sorted(Comparator.comparing(Map.Entry<Character,Long>::getValue).thenComparing(Map.Entry<Character,Long>::getKey))
		.collect(LinkedHashMap::new,
				(m,e)->m.put(e.getKey(),e.getValue()),
				LinkedHashMap::putAll
		);
		
		 //I love you
		 sortedMap.forEach((k,v)->System.out.println(k+" : "+v));
	}
	
	
	public static void question2() {
		
		Set<String> strArr=new HashSet<>();
		Boolean[] b=new Boolean[5];
		b[0]=strArr.add("a");
		b[1]=strArr.add("b");
		b[2]=strArr.add("c");
		b[3]=strArr.add("a");
		b[4]=strArr.add("d");
		
		
		Arrays.stream(b).forEach(System.out::println);
		
	}

}
