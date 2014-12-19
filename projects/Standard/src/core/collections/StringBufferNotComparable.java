package core.collections;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This example shows that StringBuffer is not comparable and therefore could
 * not be used as element in ordered collections (like the TreeSet below...).
 */
abstract class StringBufferNotComparable {
	public static void main(String[] args) {
		System.out.println("Starting...");
		SortedSet<StringBuffer> songs = new TreeSet<StringBuffer>();

		songs.add(new StringBuffer("Killing me Softly"));
		songs.add(new StringBuffer("Abonebi Abonebe"));
		songs.add(new StringBuffer("God is a DJ"));
		System.out.println("After the add");
		System.out.println(songs.first());
	}
}
