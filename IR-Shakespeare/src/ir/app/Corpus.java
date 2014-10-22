package ir.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corpus {
	
	private String text;
	private List<String> works;
	

	public Corpus(String sourcePath, String delimiter){
		works = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		try {
			Scanner scanner = new Scanner(new File(sourcePath));
			while (scanner.hasNextLine())
				sb.append(scanner.nextLine() + "\n");
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		text = sb.toString();
		for (String s : text.split(delimiter))
			works.add(s);
	}
	
	public List<String> getWorks(){
		return works;
	}

}
