package bk.ir.search.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import bk.ir.Corpus;
import bk.ir.util.Preprocessor;



public class Index {
	
	private Map<String, SortedSet<Integer>> indexMap;
	
	
	public Index(Corpus corpus){
		List<String> works = corpus.getWorks();
		List<Set<String>> terms = new ArrayList<Set<String>>();
		indexMap = new HashMap<String, SortedSet<Integer>>();
		
		//generate terms set
		System.out.print("[INDEX]\t\tGenerating terms set...");
		for (String work : works)
			terms.add(new HashSet<String>(Preprocessor.tokenize(work, Preprocessor.SPLIT_NON_WORD)));
		System.out.println(" OK");
		
		//create matrix
		System.out.print("[INDEX]\t\tCreating index...");
		long bmarkStart = System.nanoTime();
		for (Set<String> termSet : terms){
			for (String token : termSet){
				token = token.toLowerCase();
				if (!indexMap.containsKey(token))
					indexMap.put(token, new TreeSet<Integer>());
				indexMap.get(token).add(terms.indexOf(termSet));
			}
		}
		System.out.println(" mapped " + indexMap.size() + " terms.\n[DURATION]\t" + ((double)(((double)System.nanoTime() - (double)bmarkStart)/1000000)) + " ms\n");
	}
	
	public SortedSet<Integer> searchIndex(String query){
		SortedSet<Integer> result = indexMap.get(query.toLowerCase());
		return (result != null ? result : new TreeSet<Integer>());
	}

}
