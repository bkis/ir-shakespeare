package bk.ir;

import bk.ir.search.index.IndexSearch;

public class Main {

	public static void main(String[] args) {
		IndexSearch is = new IndexSearch(new Corpus("shakespeare.txt", "1[56][0-9]{2}\n"));
		is.search("Brutus Caesar");
		is.search("house");
		is.search("hand");
		is.search("dagger");
		is.search("murp");
		is.search("fatal");
		is.search("fetus");
		is.search("game");
	}

}
