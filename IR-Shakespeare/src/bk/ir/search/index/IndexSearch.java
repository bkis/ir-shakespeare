package bk.ir.search.index;

import java.util.HashSet;
import java.util.Set;

import bk.ir.ASearch;
import bk.ir.Corpus;

public class IndexSearch extends ASearch{
	
	private Index index;

	public IndexSearch(Corpus corpus) {
		super(corpus);
		index = new Index(corpus);
	}

	@Override
	public Set<Integer> search(String query) {
		benchmarkStart();
		Set<String> queries = createQuerySet(query);
		Set<Integer> result = new HashSet<Integer>();
		
		for (String q : queries){
			result.addAll(index.searchIndex(q));
		}
		
		System.out.println("[ " + query + " ] " + result + " [ " + benchmarkStop() + " ms ]");
		
		return result;
	}

}
