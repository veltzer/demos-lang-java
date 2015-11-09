package johnbryce.lab2.solution;


public class Word implements Comparable<Word>{
	private String word;
	
	public Word (String word){
		this.word=word;
	}
	   
	public String toString(){
		return word;
	}
	
	public boolean equals(Object o){
		if(o instanceof Word && o.toString().equals(word))
			return true;
		return false;
	}
	
	public int hashCode(){
		return word.hashCode();
	}
	
	public int length(){
		return word.length();
	}

	public int compareTo(Word word) {
		return this.word.compareTo(word.toString());
	}
}
