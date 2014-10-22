package ir.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Corpus {
	

	public Corpus(String sourcePath){
		StringBuilder sb = new StringBuilder();
		
		try {
			Scanner scanner = new Scanner(new File(sourcePath));
			while (scanner.hasNextLine()){
				sb.append(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String text = sb.toString();
	}
	
	public int getWorks(){
		return 0;
	}

}
