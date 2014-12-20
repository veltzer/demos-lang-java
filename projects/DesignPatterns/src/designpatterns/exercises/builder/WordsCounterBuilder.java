package designpatterns.exercises.builder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WordsCounterBuilder implements WordsBuilder
{
	private Map<String,Integer> wordsCountMap;

	public WordsCounterBuilder()
	{
		wordsCountMap = new HashMap<String,Integer>();
	}

	public void addWord(String word)
	{
		if (wordsCountMap.containsKey(word))
		{
			wordsCountMap.put(word, wordsCountMap.get(word)+1);
		}
		else
		{
			// did someone say autoboxing?
			wordsCountMap.put(word, 1);
		}
	}

	public Collection<String> getCollection()
	{
		return wordsCountMap.keySet();
		//return wordsCountMap.entrySet() ;
	}

}
