package bk.ir.search.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

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
		List<SortedSet<Integer>> allPostings = new ArrayList<SortedSet<Integer>>();
		
		for (String q : queries){
			allPostings.add(index.searchIndex(q));
		}
		
		SortedSet<Integer> result = allPostings.get(0);
		for (SortedSet<Integer> set : allPostings){
			result = Intersection.of(result, set);
		}

		System.out.println("[QUERY]\t\t[" + query + "]\n[RESULT]\t" + result + "\n[DURATION]\t[" + benchmarkStop() + " ms]\n");
		
		return result;
	}

}
