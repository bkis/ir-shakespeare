package bk.ir.search.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bk.ir.Corpus;
import bk.ir.util.Preprocessor;



public class TermDocumentMatrix {
	
	private Map<String, Set<Integer>> matrix;
	
	
	public TermDocumentMatrix(Corpus corpus){
		List<String> works = corpus.getWorks();
		List<Set<String>> terms = new ArrayList<Set<String>>();
		matrix = new HashMap<String, Set<Integer>>();
		
		//generate terms set
		System.out.print("[INFO] Generating terms set...");
		for (String work : works)
			terms.add(new HashSet<String>(Preprocessor.tokenize(work, Preprocessor.SPLIT_NON_WORD)));
		System.out.println(" OK");
		
		//create matrix
		System.out.print("[INFO] Creating term-document-matrix...");
		long bmarkStart = System.nanoTime();
		for (Set<String> termSet : terms){
			for (String token : termSet){
				token = token.toLowerCase();
				if (!matrix.containsKey(token))
					matrix.put(token, new HashSet<Integer>());
				matrix.get(token).add(terms.indexOf(termSet));
			}
		}
		System.out.println(" OK (mapped " + matrix.size() + " terms in " + ((double)(((double)System.nanoTime() - (double)bmarkStart)/1000000)) + " ms)");
	}
	
	public Set<Integer> searchMatrix(String query){
		Set<Integer> result = matrix.get(query.toLowerCase());
		return (result != null ? result : new HashSet<Integer>());
	}

}
