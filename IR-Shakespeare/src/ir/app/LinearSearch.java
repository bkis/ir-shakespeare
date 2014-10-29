package ir.app;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LinearSearch extends ASearch{
	
	public LinearSearch(Corpus corpus) {
		super(corpus);
	}
	

	@Override
	public Set<Integer> search(String query) {
		Set<Integer> result = new HashSet<Integer>();
		Set<String> queries = createQuerySet(query);
		StringTokenizer tokenizer;
		
		System.out.println("[INFO] Query: " + queries);
		
		for (String text : corpus.getWorks()){
			tokenizer = new StringTokenizer(text);
			while (tokenizer.hasMoreTokens()){
				if (queries.contains(tokenizer.nextToken().toLowerCase())){
					result.add(corpus.getWorks().indexOf(text));
					break;
				}
			}
		}
		
		return result;
	}
	

}
