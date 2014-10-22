package ir.app;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LinearSearch implements ISearch{
	
	private Corpus corpus;
	

	public LinearSearch(Corpus corpus) {
		this.corpus = corpus;
	}

	@Override
	public Set<Integer> search(String query) {
		String[] queries = query.split(" ");
		Set<Integer> result = new HashSet<Integer>();
		StringTokenizer tokenizer;
		
		for (String q : queries){
			for (String text : corpus.getWorks()){
				tokenizer = new StringTokenizer(text);
				while (tokenizer.hasMoreTokens()){
					if (tokenizer.nextToken().equalsIgnoreCase(q)){
						result.add(corpus.getWorks().indexOf(text));
						break;
					}
				}
			}
		}
		
		return result;
	}
	

}
