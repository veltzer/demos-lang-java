package johnbryce.lab6.solution;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SourceChannel;

public class ReadFromPipe implements Runnable {
	private SourceChannel src;

	public ReadFromPipe(Pipe p) {
		src = p.source();
	}

	public void run() {
		try {
			ByteBuffer buf = ByteBuffer.allocate(160);
			System.out.println(src.read(buf));
			for (int i = 0; i < 160; i += 4) {
				System.out.println(buf.getInt(i));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
