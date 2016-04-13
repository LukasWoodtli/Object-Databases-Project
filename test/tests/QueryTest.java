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

	static final String compUrl = "www.example.com";
	
	@Before
	public void setUp() throws Exception {
		Type company = new Type("Company", new String[]{"name", "url"});
		Instance myCompany = company.instanciate();
		myCompany.setAttributeValue("name", compName);
		myCompany.setAttributeValue("url", compUrl);
	}

	@Test
	public final void testQueryName() {
		ArrayList<Object> result = Extent.query("name", "Company", "name", compName);
		assertEquals(compName, result.get(0));

	}

	@Test
	public final void testQueryUrl() {
		ArrayList<Object> result = Extent.query("name", "Company", "url", compUrl);
		assertEquals(compName, result.get(0));

	}

	@Test
	public final void testQueryUrlNoResult() {
		ArrayList<Object> result = Extent.query("name", "Company", "url", "blabla");
		assertTrue(result.isEmpty());
	}
}
