package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import base.DynamicCollection;
import base.DynamicCollection.DynamicCollectionIterator;
import base.Extent;
import base.Instance;
import base.Type;

public class DynamicCollectionTest {

	static final String compName = "MyCompany";
	static final String compUrl = "www.example.com";
	
    DynamicCollection dynCol;
	DynamicCollectionIterator it;
	
	@Before
	public void setUp() throws Exception {
		Extent.clear();
		
		Type company = new Type("Company", new String[]{"name", "url"});
		Instance myCompany = company.instanciate();
		myCompany.setAttributeValue("name", compName);
		myCompany.setAttributeValue("url", compUrl);
		
		dynCol = new DynamicCollection("name", "Company", "name", compName);
		it = (DynamicCollectionIterator) dynCol.iterator();

	}


	@Test
	public final void testHasNext() {
		 assert(it.hasNext());
	}
	
	@Test
	public final void testNext() {
		assertEquals(compName, it.next().getAttributeValue("name"));
	}
	
	

}
