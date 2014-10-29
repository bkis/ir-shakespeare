package bk.ir.search.matrix;

import java.util.HashSet;
import java.util.Set;

import bk.ir.ASearch;
import bk.ir.Corpus;

public class MatrixSearch extends ASearch{
	
	private TermDocumentMatrix matrix;

	public MatrixSearch(Corpus corpus) {
		super(corpus);
		matrix = new TermDocumentMatrix(corpus);
	}

	@Override
	public Set<Integer> search(String query) {
		Set<String> queries = createQuerySet(query);
		Set<Integer> result = new HashSet<Integer>();
		
		System.out.println("\n[INFO] MatrixSearch query: " + queries);
		benchmarkStart();
		
		for (String q : queries)
			result.addAll(matrix.searchMatrix(q));
		
		System.out.println("[INFO] Search duration: " + benchmarkStop() + " ms");
		System.out.println("[INFO] Search result: " + result);
		return result;
	}

}
