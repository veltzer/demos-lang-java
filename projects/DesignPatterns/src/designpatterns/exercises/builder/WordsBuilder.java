package designpatterns.exercises.builder;

import java.util.Collection;

public interface WordsBuilder {
	void addWord(String word);

	Collection<String> getCollection();
}
