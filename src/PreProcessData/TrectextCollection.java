package PreProcessData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Classes.Path;

/**
 * This is for INFSCI 2140 in 2017
 *
 */
public class TrectextCollection implements DocumentCollection {
	//you can add essential private methods or variables
	private BufferedReader reader;
	private String line;
	
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrectextCollection() throws IOException {
		// This constructor should open the file in Path.DataTextDir
		// and also should make preparation for function nextDocument()
		// you cannot load the whole corpus into memory here!!
		
	    reader = new BufferedReader( new FileReader(new File(Path.DataTextDir))); // open the file
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, String> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NTT: remember to close the file that you opened, when you do not use it any more
		
		
	    String number = null; // DOCNO storage
	    String content=""; // TEXT content
	    
	    while ((line = reader.readLine()) != null) {
	    
			if (line.equals("<DOC>")){
	        	line=reader.readLine();// change to line of DOCNO
	        	number = line.substring(8,24); // DOCNO
		        //System.out.println(number);
	        }
	        
	        if (line.equals("<TEXT>")){
	        	line=reader.readLine();  // go to first line of content
	        	content = "";
	        	while(!line.equals("</TEXT>")){ // loop nutil the line == </TEXT>
	        		content = content + line; // content + content
		        	line=reader.readLine(); // go to next line
	        	}
		        //System.out.println(content);
	        }
	        
	        if (line.equals("</DOC>")){
	        	HashMap <String, String> map = new HashMap<String, String> ();
	        	map.put(number, content); // add to hashmap
	        	return map;
	        	//System.out.println(number); // number
		        //System.out.println(content);// content
	        	//test = map.get(number); // get from hashmap
	        	//System.out.println(test); 
		     }
	    }
	    reader.close(); // save memory
		return null;
	}
	
}
