public class Type {
	private final String name;
	private final String[] attributes;

	public Type(String name, String[] attributes) {
		this.name = name;
		this.attributes = attributes;
	}
	
	public Instance instanciate() {
		return new Instance(this);
	}
}
