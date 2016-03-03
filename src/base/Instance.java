package base;
import java.util.Map;
import java.util.HashMap;

public class Instance {
	
	private final Type type;
	private final Map<String, Object> dictAttributes;

	public Instance(Type type) {
		this.dictAttributes = new HashMap<String, Object>();
		this.type = type;
	}
	
	public void setAttributeValue(String attrName, Object attrValue) {
		type.exceptWhenAttributeNotAvailable(attrName);
		this.dictAttributes.put(attrName, attrValue);
	}
	
	public Object getAttributeValue(String attrName) {
		
		type.exceptWhenAttributeNotAvailable(attrName);
		
		return this.dictAttributes.get(attrName);
	}
}
