package bk.ir.search.index;

import java.util.SortedSet;


public class Intersection {
	
	public static SortedSet<Integer> of(SortedSet<Integer> p1, SortedSet<Integer> p2){
		p1.retainAll(p2);
		return p1;
	}

}
