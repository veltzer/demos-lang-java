package designpatterns.exercises.decorator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class WordsReader extends Reader {
	private Reader reader;

	public WordsReader(Reader ireader) {
		reader = ireader;
	}

	public int read(char[] cbuf, int off, int len) throws IOException {
		return reader.read(cbuf, off, len);
	}

	public void close() throws IOException {
		reader.close();
	}

	public String readWord() throws IOException {
		int c = 0;
		while ((c >= 0) && !Character.isLetter(c)) {
			c = reader.read();
		}
		if (c < 0) { // EOF
			return null;
		}
		StringBuffer result = new StringBuffer();
		while ((c >= 0) && Character.isLetter(c)) {
			result.append((char) c);
			c = reader.read();
		}

		if (result.length() == 0) {
			return null;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		try {
			File inputFile = new File("/tmp/words.txt");
			//WordsBuilder builder = new WordsCounterBuilder();
			WordsReader reader = new WordsReader(new FileReader(inputFile));
			String word = null;
			while ((word = reader.readWord()) != null) {
				System.out.println("<" + word + ">");
			}
			System.out.println("Done");
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
