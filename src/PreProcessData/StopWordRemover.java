package PreProcessData;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import Classes.Path;

public class StopWordRemover {
	//you can add essential private methods or variables
	HashSet<String> object = new HashSet <String> (); 
	FileInputStream stopwordfile = null;
	BufferedReader reader;
	
	public StopWordRemover( ) throws IOException {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		// address of stopword.txt should be Path.StopwordDir
		stopwordfile = new FileInputStream(Path.StopwordDir);
		reader = new BufferedReader(new InputStreamReader(stopwordfile));    
		String line = reader.readLine();
		
		while (line != null){
			//System.out.println(line);
			object.add(line); // add to hashset
			line = reader.readLine(); // go to next line
		}
		

		
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword(String word ) {
		// return true if the input word is a stopword, or false if not
		
		if(object.contains(word)) { // compare if word is contained in hashset or not
			//System.out.println(word+" is stop word"); 
			return true;
		}else{
			//System.out.println(word+" is not stop word");
			return false;
		}
		
	}
}
