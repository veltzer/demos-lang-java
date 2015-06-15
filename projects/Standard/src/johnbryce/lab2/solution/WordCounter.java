import java.io.*;
import java.util.*;

public class WordCounter {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		String fileName="text.txt";
		BufferedReader in=new BufferedReader(new FileReader(fileName));		
		Map<Word,Integer> count=new TreeMap<Word,Integer>();
		String line=in.readLine();
		String curr=null;
		int frequency=0;
		while(line!=null){
			StringTokenizer token=new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				curr=token.nextToken();				
				Word w=new Word(curr.toLowerCase());
				try{
					frequency=count.get(new Word(curr));
					frequency=frequency+1;
				}catch(NullPointerException e){
					frequency=1;
				}	
				count.put(w,frequency);	
			}
			line=in.readLine();
		}
		//print no 1
		System.out.println(count);
		
		List words=new ArrayList(count.keySet());
		LetterCountComperator letterCountComperator = new LetterCountComperator();
		Collections.sort(words,letterCountComperator);
		//print no 2
		System.out.println(words);
	}
}
