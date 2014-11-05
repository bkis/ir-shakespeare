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
		bmarkStart = (double) System.nanoTime();
	}
	
	
	public double benchmarkStop(){
		return (double)(((double)System.nanoTime() - (double)bmarkStart)/1000000);
	}
	
	
	public abstract Set<Integer> search(String query);
	
}
