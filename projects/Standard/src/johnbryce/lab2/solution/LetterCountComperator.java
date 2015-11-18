package johnbryce.lab2.solution;

import java.util.Comparator;

public class LetterCountComperator implements Comparator<Word> {

	public int compare(Word w1, Word w2){
		return w1.length()-w2.length();
	}

}
