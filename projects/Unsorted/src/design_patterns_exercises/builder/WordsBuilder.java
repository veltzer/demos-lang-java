package design_patterns_exercises.src.dp.builder;

import java.util.Collection;

public interface WordsBuilder
{
	public void addWord( String word ) ;
	public Collection<String> getCollection() ;
}
