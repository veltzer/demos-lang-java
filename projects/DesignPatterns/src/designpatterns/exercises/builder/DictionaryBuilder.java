package designpatterns.exercises.builder;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class DictionaryBuilder implements WordsBuilder {
	private SortedSet<String> dictionary;
	public DictionaryBuilder() {
		dictionary = new TreeSet<String>();
	}
	public void addWord(String word) {
		dictionary.add(word);
	}
	public Collection<String> getCollection() {
		return dictionary;
	}
}
