package johnbryce.lab6.exercise;

import java.nio.channels.Pipe;

public abstract class ChanelsExample {

	public static void main(String[] args) throws Exception {
		Pipe p = null; // enter text here
		Thread writer = new Thread(new WriteToPipe(p));
		Thread reader = new Thread(new ReadFromPipe(p));
		writer.start();
		Thread.sleep(1000);
		reader.start();
	}
}
