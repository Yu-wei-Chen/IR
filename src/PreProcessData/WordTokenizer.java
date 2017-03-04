package PreProcessData;

/**
 * This is for INFSCI 2140 in 2017
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	//you can add essential private methods or variables
	String tokenizerword[];
	int i = 0;
	int wordlength;
	
	// YOU MUST IMPLEMENT THIS METHOD
	public WordTokenizer( String texts ) {
		// this constructor will tokenize the input texts
		// please remove all punctuations
		String tokenizer =new String(texts);
		tokenizer = tokenizer.replaceAll("[\\pP‘’“”]", ""); // remove punctuations
		tokenizerword = tokenizer.split(" "); // split word
		wordlength = tokenizerword.length; // the size of the tokenizerword
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public String nextWord() {
		// read and return the next word of the document
		// or return null if it is the end of the document
		if (i < wordlength){
				//System.out.println(tokenizerword[i]); 
				i++;
				return tokenizerword[i-1]; // because of i++ so use i-1
			}
		return null;
		
	}
	
}
