package bk.ir;

import bk.ir.search.matrix.MatrixSearch;

public class Main {

	public static void main(String[] args) {
		MatrixSearch ms = new MatrixSearch(new Corpus("shakespeare.txt", "1[56][0-9]{2}\n"));
		ms.search("Brutus Caesar");
		ms.search("house");
		ms.search("hand");
		ms.search("dagger");
		ms.search("murp");
		ms.search("fatal");
		ms.search("fetus");
		ms.search("game");
	}

}
