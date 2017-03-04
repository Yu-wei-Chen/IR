package PreProcessData;
import Classes.Stemmer;

/**
 * This is for INFSCI 2140 in 2017
 * 
 */
public class WordNormalizer {
	//you can add essential private methods or variables
	
	// YOU MUST IMPLEMENT THIS METHOD
	public String lowercase(String chars ) {
		//transform the uppercase characters in the word to lowercase
		chars = chars.toLowerCase(); // change to lowercase 
		return chars;
	}
	
	public String stem(String chars)
	{
		//use the stemmer in Classes package to do the stemming on input word, and return the stemmed word
		String str="";
		
		char[] charArray = chars.toCharArray(); // change String to Char[] 
		
		Stemmer stemming = new Stemmer();
		stemming.add(charArray, charArray.length); // call add() in stemmer
		stemming.stem(); // call stem() to do stemming 
		
		str = stemming.toString(); // change back to String 
		//System.out.println(str+"--stemmed");  
		return str; // return stemmed word to main
	}
	
}
