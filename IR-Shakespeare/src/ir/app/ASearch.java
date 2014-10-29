package ir.app;

import java.util.HashSet;
import java.util.Set;

public abstract class ASearch {
	
	protected Corpus corpus;
	private long bmarkStart;
	
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
	
	
	protected void benchmarkStart(){
		bmarkStart = System.currentTimeMillis();
	}
	
	
	protected long benchmarkStop(){
		return System.currentTimeMillis() - bmarkStart;
	}
	
	
	public abstract Set<Integer> search(String query);
	
}
