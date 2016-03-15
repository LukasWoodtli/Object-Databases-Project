package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import base.Instance;
import base.Type;

// http://stackoverflow.com/a/1119559/1272072

public class MethodsTest {

	// for checking what's written to stdout
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
	}
	

	@After
	public void tearDown() {
		System.setOut(null);
	}
	
	@Test
	public final void methodTest() {
		Type bird = new Type("bird", new String[]{});
		bird.addMethod("print", "System.out.println(\"Hello\");");
		Instance woodstock = bird.instanciate();
		woodstock.invoke("print");
		
		assertEquals("Hello\n", outContent.toString());
	}
}
