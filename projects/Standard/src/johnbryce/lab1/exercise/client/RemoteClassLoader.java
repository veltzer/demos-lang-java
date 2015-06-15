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
			//enter text here
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
