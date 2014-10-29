package bk.ir;

import java.util.HashSet;
import java.util.Set;

public abstract class ASearch {
	
	protected Corpus corpus;
	private double bmarkStart;
	
	public ASearch(Corpus corpus){
		this.corpus = corpus;
	}
	
	
	protected Set<String> createQuerySet(String query){
		Set<String> queries = new HashSet<String>();
		String[] q = query.split(" ");
		
		for (String s : q)
			queries.add(s.toLowerCase());
		
		return queries;
	}
	
	
	public void benchmarkStart(){
		bmarkStart = (float)System.nanoTime()/1000000;
	}
	
	
	public double benchmarkStop(){
		return (double)System.nanoTime()/1000000 - bmarkStart;
	}
	
	
	public abstract Set<Integer> search(String query);
	
}
