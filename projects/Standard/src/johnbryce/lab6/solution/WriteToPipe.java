package johnbryce.lab6.solution;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;

public class WriteToPipe implements Runnable {
	private SinkChannel sink;
	public WriteToPipe(Pipe p){
		 sink=p.sink();
	}
	public void run(){
		try {
			ByteBuffer buf=ByteBuffer.allocate(160);
			IntBuffer intBuf=buf.asIntBuffer();
			for(int i=0;i<40;i++){
				intBuf.put(i+1);
			}
			sink.write(buf);
			System.out.println("Pipe loaded");
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
