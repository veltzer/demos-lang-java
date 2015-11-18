package johnbryce.lab1.solution.client;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class RemoteClassLoader extends ClassLoader {

	private String host;
	private int port;
	private ObjectInputStream in;
	private DataOutputStream out;

	public RemoteClassLoader(String host,int port){
		this.host=host;
		this.port=port;
	}

	public Class<?> findClass (String className) {
		try {
			Socket s=new Socket(host,port);
			out=new DataOutputStream(s.getOutputStream());
			out.writeUTF(className);
			in=new ObjectInputStream(s.getInputStream());
			byte[] classData=(byte[])in.readObject();
			s.close();
			if(classData==null){
				throw new NoClassDefFoundError();
			}
			return defineClass(className,classData, 0, classData.length);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
