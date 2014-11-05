package bk.ir.util;

import java.util.Arrays;
import java.util.List;

public class Preprocessor {
	
	public static final String SPLIT_NON_WORD = "[\\P{L}]+";

	
	public static List<String> tokenize(String input, String pattern){
		return Arrays.asList(input.toLowerCase().split(pattern));
	}

}
