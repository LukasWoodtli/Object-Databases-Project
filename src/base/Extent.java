package base;

import base.Instance;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Extent {

	static HashSet<Instance> extent = new HashSet<Instance>();

	public static void store(Instance value) {
		extent.add(value);		
	}
	
	public static ArrayList<Object> query(String select, String from, String whereProp, Object whereVal) {
		// from
		HashSet<Instance> query = (HashSet<Instance>)extent.stream().filter(x -> x.getTypeName() == from).collect(Collectors.toSet());
		
		// where
		query = (HashSet<Instance>)query.stream().filter(x -> x.getAttributeValue(whereProp) == whereVal).collect(Collectors.toSet());
		
		ArrayList<Object> result = new ArrayList<Object>(); 
		
		// select
		for (Instance i : query) {
			result.add(i.getAttributeValue(select));
		}
		
		return result;
	}
}
