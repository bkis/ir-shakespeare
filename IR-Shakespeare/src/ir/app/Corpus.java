package ir.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Corpus {
	
	private String text;
	List<String> works;
	

	public Corpus(String sourcePath, String delimiter){
		StringBuilder sb = new StringBuilder();
		
		try {
			Scanner scanner = new Scanner(new File(sourcePath));
			while (scanner.hasNextLine())
				sb.append(scanner.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		text = sb.toString();
		text.split(delimiter);
	}
	
	public List<String> getWorks(){
		return works;
	}

}
