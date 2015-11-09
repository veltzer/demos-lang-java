package johnbryce.lab1.exercise.client;
import java.net.Socket;

public class RemoteClassLoader extends ClassLoader {
	
	private String host;
	private int port;
	
	public RemoteClassLoader(String host,int port) {
		this.host=host;
		this.port=port;
	}
	
	public Class<?> findClass (String className) {
		try {
			Socket s=new Socket(host,port);
			//enter text here
            s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
