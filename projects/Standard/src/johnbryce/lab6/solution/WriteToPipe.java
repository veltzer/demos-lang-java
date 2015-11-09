package johnbryce.lab6.solution;
import java.nio.channels.*;
import java.nio.channels.Pipe.*;
import java.nio.*;

public class WriteToPipe implements Runnable {
	private SinkChannel sink;
	public WriteToPipe(Pipe p){
		 sink=p.sink();
	}
	public void run(){
		try{
			
			ByteBuffer buf=ByteBuffer.allocate(160);			
			IntBuffer intBuf=buf.asIntBuffer();
			for(int i=0;i<40;i++){
				intBuf.put(i+1);
			}
			sink.write(buf);
			
			
			System.out.println("Pipe loaded");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
