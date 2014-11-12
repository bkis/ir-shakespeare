package bk.ir.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Preprocessor {
	
	public static final String SPLIT_NON_WORD = "[\\P{L}]+";

	
	public static Set<String> tokenize(String input, String pattern){
		Set<String> queries = new HashSet<String>();
		queries.addAll(Arrays.asList(input.toLowerCase().split(pattern)));
		return queries;
	}

}
