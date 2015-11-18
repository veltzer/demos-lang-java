package johnbryce.lab2.solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public abstract class WordCounter {

	public static void main(String[] args) {
		String fileName = "text.txt";
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e1) {
			throw new RuntimeException(e1);
		}
		Map<Word, Integer> count = new TreeMap<Word, Integer>();
		String line;
		try {
			line = in.readLine();
		} catch (IOException e1) {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(e1);
		}
		String curr = null;
		int frequency = 0;
		while (line != null) {
			StringTokenizer token = new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				curr = token.nextToken();
				Word w = new Word(curr.toLowerCase());
				try {
					frequency = count.get(new Word(curr));
					frequency = frequency + 1;
				} catch (NullPointerException e) {
					frequency = 1;
				}
				count.put(w, frequency);
			}
			try {
				line = in.readLine();
			} catch (IOException e) {
				try {
					in.close();
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				}
				throw new RuntimeException(e);
			}
		}
		try {
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// print no 1
		System.out.println(count);

		List<Word> words = new ArrayList<Word>(count.keySet());
		LetterCountComperator letterCountComperator = new LetterCountComperator();
		Collections.sort(words, letterCountComperator);
		// print no 2
		System.out.println(words);
	}
}
