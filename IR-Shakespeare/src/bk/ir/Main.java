package bk.ir;

import bk.ir.search.index.IndexSearch;

public class Main {

	public static void main(String[] args) {
		IndexSearch is = new IndexSearch(new Corpus("shakespeare.txt", "1[56][0-9]{2}\n"));
		is.search("thy");
		is.search("thy Brutus");
		is.search("thy Brutus Caesar");
		is.search("thy Brutus Caesar tree");
	}

}
