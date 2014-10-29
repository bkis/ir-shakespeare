package ir.app;

import java.util.HashSet;
import java.util.Set;

public abstract class ASearch {
	
	protected Corpus corpus;
	
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
	
	public abstract Set<Integer> search(String query);
	
}
