package ir.tests;


import static org.junit.Assert.assertTrue;
import ir.app.Corpus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestIR {
	
	private Corpus corpus;
	
	
	
	@BeforeClass
	public static void before(){
		
	}
	
	@Before
	public void setUp() throws Exception{
		//Corpus einlesen, in Werke einteilen
		corpus = new Corpus("shakespeare.txt");
		System.out.println("### NEW TEST ###");
	}
	
	
	
	
	@Test
	public void testCorpus() {
		//Corpus ansprechen, auf Existenz testen, mehr als ein Werk?
		assertTrue("Corpus > 1 Werk", corpus.getWorks() > 1);
	}
	
	@Test
	public void testLinearSearch(){
		//assertTrue("", condition);	
	}
	
	@Test
	public void testMatrixSearch(){
		//assertTrue("", condition);	
	}
	
	@Test
	public void testIndexSearch(){
		//assertTrue("", condition);	
	}
	
	
	
	
	@After
	public void tearDown(){
		
	}
	
	@AfterClass
	public void finish(){
		
	}

}
