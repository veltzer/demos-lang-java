/*
 * Created on Jan 23, 2006
 */
package dp.builder;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class DictionaryBuilder implements WordsBuilder
{
	private SortedSet<String> dictionary;

	public DictionaryBuilder()
	{
		dictionary = new TreeSet<String>();
	}

	public void addWord(String word)
	{
		dictionary.add(word);
	}

	public Collection getCollection()
	{
		return dictionary;
	}

}
