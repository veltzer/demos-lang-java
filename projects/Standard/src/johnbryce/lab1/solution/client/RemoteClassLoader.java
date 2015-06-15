package client;
import java.io.*;
import java.net.*;

public class RemoteClassLoader extends ClassLoader {
	
	private String host;
	private int port;
	private ObjectInputStream in;
	private DataOutputStream out;
	
	public RemoteClassLoader(String host,int port){
		this.host=host;
		this.port=port;
	}
	
	public Class findClass (String className){
		
		try {
			Socket s=new Socket(host,port);
			out=new DataOutputStream(s.getOutputStream());
			out.writeUTF(className);
			in=new ObjectInputStream(s.getInputStream());
			byte[] classData=(byte[])in.readObject();
			if(classData==null){
				throw new NoClassDefFoundError();
			}
			return defineClass(className,classData, 0, classData.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
