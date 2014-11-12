package bk.ir.search.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bk.ir.Corpus;
import bk.ir.util.Preprocessor;



public class Index {
	
	private Map<String, Set<Integer>> indexMap;
	
	
	public Index(Corpus corpus){
		List<String> works = corpus.getWorks();
		List<Set<String>> terms = new ArrayList<Set<String>>();
		indexMap = new HashMap<String, Set<Integer>>();
		
		//generate terms set
		System.out.print("[INFO] Generating terms set...");
		for (String work : works)
			terms.add(new HashSet<String>(Preprocessor.tokenize(work, Preprocessor.SPLIT_NON_WORD)));
		System.out.println(" OK");
		
		//create matrix
		System.out.print("[INFO] Creating index...");
		long bmarkStart = System.nanoTime();
		for (Set<String> termSet : terms){
			for (String token : termSet){
				token = token.toLowerCase();
				if (!indexMap.containsKey(token))
					indexMap.put(token, new HashSet<Integer>());
				indexMap.get(token).add(terms.indexOf(termSet));
			}
		}
		System.out.println(" OK (mapped " + indexMap.size() + " terms in " + ((double)(((double)System.nanoTime() - (double)bmarkStart)/1000000)) + " ms)");
	}
	
	public Set<Integer> searchIndex(String query){
		Set<Integer> result = indexMap.get(query.toLowerCase());
		return (result != null ? result : new HashSet<Integer>());
	}

}
