package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import base.Instance;
import base.Type;

public class InstanceTest {

	private Type company;

	@Before
	public void setUp() throws Exception {
		company = new Type("Company", new String[]{"name", "url"});
	}

	@Test
	public final void testInstance() {
		assert(company.instanciate() != null);
	}

	@Test
	public final void testGetSetAttributeValue() {
		final String compName = "Super & Co";
		Instance myCompany = company.instanciate();
		myCompany.setAttributeValue("name", compName);
		assertEquals(compName, myCompany.getAttributeValue("name"));
	}

}
