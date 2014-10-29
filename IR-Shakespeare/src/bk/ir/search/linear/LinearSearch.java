package bk.ir.search.linear;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import bk.ir.ASearch;
import bk.ir.Corpus;

public class LinearSearch extends ASearch{
	
	public LinearSearch(Corpus corpus) {
		super(corpus);
	}
	

	@Override
	public Set<Integer> search(String query) {
		benchmarkStart();
		Set<Integer> result = new HashSet<Integer>();
		Set<String> queries = createQuerySet(query);
		StringTokenizer tokenizer;
		
		System.out.println("[INFO] LinearSearch query: " + queries);
		
		for (String text : corpus.getWorks()){
			tokenizer = new StringTokenizer(text);
			while (tokenizer.hasMoreTokens()){
				if (queries.contains(tokenizer.nextToken().toLowerCase())){
					result.add(corpus.getWorks().indexOf(text));
					break;
				}
			}
		}
		
		System.out.println("[INFO] Search duration: " + benchmarkStop() + " ms");
		return result;
	}
	

}
