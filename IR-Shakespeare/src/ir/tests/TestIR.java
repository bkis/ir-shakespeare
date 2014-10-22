package ir.tests;


import static org.junit.Assert.assertTrue;
import ir.app.Corpus;
import ir.app.IndexSearch;
import ir.app.LinearSearch;
import ir.app.MatrixSearch;

import java.util.Set;

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
		corpus = new Corpus("shakespeare.txt", "1[56][0-9]{2}\n");
		System.out.println("\n\n### NEW TEST ###\n");
	}
	
	
	
	
	@Test
	public void testCorpus() {
		//Corpus ansprechen, auf Existenz testen, mehr als ein Werk?
		assertTrue("Corpus > 1 Werk", corpus.getWorks().size() > 1);
		System.out.println("Anzahl der Werke: " + corpus.getWorks().size());
	}
	
	@Test
	public void testLinearSearch(){
		//Lineare Suche testen
		LinearSearch linear = new LinearSearch(corpus);
		
		String query = "Brutus";
		Set<Integer> result = linear.search(query);
		assertTrue("Ergebnis sollte nicht leer sein.", result.size() > 0);	
		
		String query2 = "Brutus Caesar";
		Set<Integer> result2 = linear.search(query2);
		assertTrue("Ergebnismenge sollte gewachsen sein.", result2.size() > result.size());	
	}
	
	@Test
	public void testMatrixSearch(){
		//Matrix-Suche testen
		MatrixSearch matrix = new MatrixSearch(corpus);
		
		String query = "Brutus";
		Set<Integer> result = matrix.search(query);
		assertTrue("Ergebnis sollte nicht leer sein.", result.size() > 0);	
		
		String query2 = "Brutus Caesar";
		Set<Integer> result2 = matrix.search(query2);
		assertTrue("Ergebnismenge sollte gewachsen sein.", result2.size() > result.size());	
	}
	
	@Test
	public void testIndexSearch(){
		//Index-Suche testen
		IndexSearch index = new IndexSearch(corpus);
		
		String query = "Brutus";
		Set<Integer> result = index.search(query);
		assertTrue("Ergebnis sollte nicht leer sein.", result.size() > 0);	
		
		String query2 = "Brutus Caesar";
		Set<Integer> result2 = index.search(query2);
		assertTrue("Ergebnismenge sollte gewachsen sein.", result2.size() > result.size());	
	}
	
	
	
	
	@After
	public void tearDown(){
		
	}
	
	@AfterClass
	public static void finish(){
		
	}

}
