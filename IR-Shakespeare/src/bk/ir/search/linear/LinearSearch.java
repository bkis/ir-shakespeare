package bk.ir.search.linear;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bk.ir.ASearch;
import bk.ir.Corpus;
import bk.ir.util.Preprocessor;

public class LinearSearch extends ASearch{
	
	public LinearSearch(Corpus corpus) {
		super(corpus);
	}
	

	@Override
	public Set<Integer> search(String query) {
		Set<Integer> result = new HashSet<Integer>();
		Set<String> queries = createQuerySet(query);
		List<String> tokens;
		
		System.out.println("\n[INFO] LinearSearch query: " + queries);
		benchmarkStart();
		
		for (String text : corpus.getWorks()){
			tokens = Preprocessor.tokenize(text, Preprocessor.SPLIT_NON_WORD);
			for (String token : tokens){
				if (queries.contains(token.toLowerCase())){
					result.add(corpus.getWorks().indexOf(text));
					break;
				}
			}
		}
		
		System.out.println("[INFO] Search duration: " + benchmarkStop() + " ms");
		System.out.println("[INFO] Search result: " + result);
		return result;
	}
	

}
