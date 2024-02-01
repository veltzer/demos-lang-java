package johnbryce.lab4.exercise;

import java.util.Collection;
import java.util.Vector;

public abstract class Run {

	/**
	 * args[0] is the location to start (e.g. "c:/myDir") args[1] is the file
	 * extension to search (e.g. "exe")
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Collection<String> files = new Vector<>();
		// DirectorySearch search=new DirectorySearch(args[0],args[1],files);

		// create the fork join pool
		// enter text here

		System.out.println("Searching Directories: \n");

		// invoke your first task with the pool
		// enter text here

		System.out.println("\n\nFounded Files: \n");
		for (String file : files) {
			System.out.println(file);
		}
		System.out.println(System.currentTimeMillis() - start + " milis");
	}

}
