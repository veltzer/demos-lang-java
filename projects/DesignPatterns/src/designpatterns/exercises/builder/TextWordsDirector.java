package designpatterns.exercises.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TextWordsDirector {
	private WordsBuilder builder;

	public TextWordsDirector(WordsBuilder ibuilder) {
		builder = ibuilder;
	}

	public void produceCollection(File textFile) {
		// We can begin with a predefined array of words (skip the file reading...)
		// We simply iterate through this array as if these are the words we read from file.
		//String[] myWords = { "the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" } ;

		// Hint: the following code splits a text line into words:
		// String[] words = line.split("[\\W]+");

		try {
			// Bug here: empty lines are considered as a word...
			// Can you think of an alternative way for reading words from a file?
			BufferedReader reader = new BufferedReader(new FileReader(textFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("[^\\w]+");
				for (int i = 0; i < words.length; ++i) {
					builder.addWord(words[i]);
				}
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void printCollection() {
		for (Iterator<String> i = builder.getCollection().iterator(); i.hasNext();) {
			System.out.println("" + i.next());
		}
	}

	public static void main(String[] args) {
		try {
			File inputFile = new File("/tmp/words.txt");
			WordsBuilder builder = new WordsCounterBuilder();
			//WordsBuilder builder = new DictionaryBuilder();

			TextWordsDirector director = new TextWordsDirector(builder);
			director.produceCollection(inputFile);
			director.printCollection();

			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
