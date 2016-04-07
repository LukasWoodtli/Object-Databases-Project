package base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Type {
	private final String name;
	private final Set<String> attributes;
	private final Map<String, String> methods;

	public Type(String name, String[] attributes) {
		this.name = name;
		this.attributes = new HashSet<String>(Arrays.asList(attributes));
		this.methods = new HashMap<String, String>();
		
	}
	
	public Instance instanciate() {
		Instance inst = new Instance(this);
		Extent.store(inst);
		return inst;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addMethod(String name, String code) {
		this.methods.put(name, code);
	}
	
	public void exceptWhenAttributeNotAvailable(String attrName) {
		if (!checkIfAttributeAvailable(attrName)){
			System.out.println("Error: Attribute " + attrName + " not found in " + this.name);
		}
	}
	
	private boolean checkIfAttributeAvailable(String attrName) {
		return this.attributes.contains(attrName);
	}

	public void invoke(String methodName) {
		String code = classTemplateString.replace("%%NAME%%", getName() + methodName);
		code = code.replace("%%CODE%%", this.methods.get(methodName));
		
        RuntimeCompiler r = new RuntimeCompiler();
        r.addClass(getName() + methodName, code);
        r.compile();

        MethodInvocationUtils.invokeStaticMethod(
            r.getCompiledClass(getName() + methodName), 
            "doIt");
	}
	
	private final String classTemplateString = "public class %%NAME%% { public static void doIt() { %%CODE%% } }";
}
