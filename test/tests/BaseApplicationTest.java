package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import base.Instance;
import base.Type;

public class BaseApplicationTest {


	@Test
	public final void test() {
		
		// DD Create a type declaring attributes
		Type person = new Type("Person", new String[] {"name", "email", "employer"});
		Type company = new Type("Company", new String[] {"name", "url" });
		
		// DM Create an instance of this type, set and get attribute values
		Instance acme = company.instanciate();
		acme.setAttributeValue("name", "Acme INc.");
		acme.setAttributeValue("url", "http://www.acme.co.uk");
		
		Instance stinnet = person.instanciate();
		stinnet.setAttributeValue("name", "Bill Stinnet");
		stinnet.setAttributeValue("email", "stinnet@gmail.com");
		stinnet.setAttributeValue("emplayer", "acme");

		assertEquals("Test querry",
					 "Bill Stinnet stinnet@gmail.com",
				     stinnet.getAttributeValue("name") + " " + stinnet.getAttributeValue("email"));
		
	}

}
