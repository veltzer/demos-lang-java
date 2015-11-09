package johnbryce.lab6.solution;

import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;

public class ChanelsExample {
	public static void main(String[] args) throws Exception {
		Pipe p=SelectorProvider.provider().openPipe();
		
		Thread writer=new Thread (new WriteToPipe(p));
		Thread reader=new Thread (new ReadFromPipe(p));
		writer.start();
		Thread.sleep(1000);
		reader.start();
	}
}
