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
public class TrecwebCollection implements DocumentCollection {
	//you can add essential private methods or variables
	private BufferedReader reader;
	private String line;
	
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrecwebCollection() throws IOException {
		// This constructor should open the file in Path.DataWebDir
		// and also should make preparation for function nextDocument()
		// you cannot load the whole corpus into memory here!!
		reader = new BufferedReader( new FileReader(new File(Path.DataWebDir)));
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, String> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NT: the returned content of the document should be cleaned, all html tags should be removed.
		// NTT: remember to close the file that you opened, when you do not use it any more
		
		
	    String number = null; // DOCNO
	    String content=""; // TEXT content
		
	    while ((line = reader.readLine()) != null) {
	    
		    if (line.equals("<DOC>")){
	        	line=reader.readLine(); // change line
	        	number = line.substring(7,24); // DOCNO
		        //System.out.println(number);
	        }
	        
	        if (line.equals("</DOCHDR>")){
	        	line=reader.readLine();  // go to first line of content
	        	content = "";
	        	while(!line.equals("</DOC>")){
	        		content = content + line; // content + content
	        		content = content.replaceAll("<[^>]*>", " "); // remove the html tag
		        	line=reader.readLine();
	        	}
		        //System.out.println(content);
	        }
	        
	        if (line.equals("</DOC>")){
	        	HashMap <String, String> map = new HashMap<String, String> ();
	        	map.put(number, content); // add to hashmap
	        	return map;
	        	//test = map.get(number); // get from hashmap
	        	//System.out.println(test); 
	        	//System.out.println(number); // number
		        //System.out.println(content);// content
		     }
	    }
	    reader.close(); // close reader save memory  
		return null;
	}
	
}
