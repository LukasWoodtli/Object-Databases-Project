package base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Type {
	private final String name;
	private final Set<String> attributes;

	public Type(String name, String[] attributes) {
		this.name = name;
		this.attributes = new HashSet<String>(Arrays.asList(attributes));
	}
	
	public Instance instanciate() {
		return new Instance(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void exceptWhenAttributeNotAvailable(String attrName) {
		if (!checkIfAttributeAvailable(attrName)){
			System.out.println("Error: Attribute " + attrName + " not found in " + this.name);
		}
	}
	
	private boolean checkIfAttributeAvailable(String attrName) {
		return this.attributes.contains(attrName);
	}
}
