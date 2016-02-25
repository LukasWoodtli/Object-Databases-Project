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
		this.dictAttributes.put(attrName, attrValue);
	}
	
	public String getAttributeValue(String attrName) {
		
		String result = this.dictAttributes.get(attrName).toString();
		
		if(result != null)		
			return result;
		return "";		
	}
}
