public class Driver {
	public static void main(String[] args) {
		Type person = new Type("Person", new String[] {"name", "email", "employer"});
		Type company = new Type("Company", new String[] {"name", "url" });
		
		Instance acme = company.instanciate();
		acme.setAttributeValue("name", "Acme INc.");
		acme.setAttributeValue("url", "http://www.acme.co.uk");
		
		Instance stinnet = person.instanciate();
		stinnet.setAttributeValue("name", "Bill Stinnet");
		stinnet.setAttributeValue("email", "stinnet@gmail.com");
		stinnet.setAttributeValue("emplayer", "acme");

		System.out.println(stinnet.getAttributeValue("name") + " " + stinnet.getAttributeValue("email"));
		
	}
}
