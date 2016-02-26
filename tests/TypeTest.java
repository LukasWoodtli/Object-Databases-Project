package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import base.Type;

public class TypeTest {

	private Type person;
	
	@Before
	public void setUp() throws Exception {
		person = new Type("Person", new String[]{"name", "email", "employer"});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testInstanciate() {
		assertTrue(person.instanciate() != null);
	}

	@Test
	public final void testGetName() {
		assertEquals(person.getName(), "Person");
	}
}
