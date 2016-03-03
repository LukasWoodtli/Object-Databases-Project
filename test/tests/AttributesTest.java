package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import base.Instance;
import base.Type;

public class AttributesTest {
	
	private Instance dumbo;
	
	public AttributesTest() {
		Type elephant = new Type("elephant", new String[]{"ears", "trunk", "feet"});
		this.dumbo = elephant.instanciate();
	}

	@Test
	public final void testEars() {
		this.dumbo.setAttributeValue("ears", "flap");
		assertEquals("flap",this.dumbo.getAttributeValue("ears"));		
	}

	@Test
	public final void testNoFlapper() {
		assertEquals(null, this.dumbo.getAttributeValue("flapper"));		
	}

}
