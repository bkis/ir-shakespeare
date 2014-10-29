package bk.ir.search.linear;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bk.ir.ASearch;
import bk.ir.Corpus;
import bk.ir.util.Tokenizer;

public class LinearSearch extends ASearch{
	
	public LinearSearch(Corpus corpus) {
		super(corpus);
	}
	

	@Override
	public Set<Integer> search(String query) {
		Set<Integer> result = new HashSet<Integer>();
		Set<String> queries = createQuerySet(query);
		List<String> tokens;
		
		System.out.println("[INFO] LinearSearch query: " + query);
		benchmarkStart();
		
		for (String text : corpus.getWorks()){
			tokens = Tokenizer.tokenize(text, Tokenizer.SPLIT_NON_WORD);
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
