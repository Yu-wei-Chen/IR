import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class test_result {
	BufferedReader reader;
	@Test
	public void test() throws IOException {
		String line;
		int i = 0;
		reader = new BufferedReader( new FileReader(new File("data//result.trectext"))); //result.trecweb
		
		while ((line = reader.readLine()) != null) {
			if (i == 10) {
				break;
			}
			System.out.println(line);
			i++;
		}
	}

}
