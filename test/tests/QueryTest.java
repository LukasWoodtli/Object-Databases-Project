package tests;


import base.Extent;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import base.Instance;
import base.Type;

public class QueryTest {

	static final String compName = "Super & Co";

	@Before
	public void setUp() throws Exception {
		Type company = new Type("Company", new String[]{"name", "url"});
		Instance myCompany = company.instanciate();
		myCompany.setAttributeValue("name", compName);
	}

	@Test
	public final void test() {
		ArrayList<Object> result = Extent.query("name", "Company", "name", compName);
		assertEquals(compName, result.get(0));

	}

}
