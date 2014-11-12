package bk.ir;

import java.util.Set;

import bk.ir.util.Preprocessor;

public abstract class ASearch {
	
	protected Corpus corpus;
	private double bmarkStart;
	
	public ASearch(Corpus corpus){
		this.corpus = corpus;
	}
	
	
	protected Set<String> createQuerySet(String query){
		return Preprocessor.tokenize(query, Preprocessor.SPLIT_NON_WORD);
	}
	
	
	public void benchmarkStart(){
		bmarkStart = (double) System.nanoTime();
	}
	
	
	public double benchmarkStop(){
		return (double)(((double)System.nanoTime() - (double)bmarkStart)/1000000);
	}
	
	
	public abstract Set<Integer> search(String query);
	
}
