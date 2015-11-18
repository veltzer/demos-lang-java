package johnbryce.lab1.exercise.client;

import java.net.Socket;

public class RemoteClassLoader extends ClassLoader {

	private String host;
	private int port;

	public RemoteClassLoader(String ihost, int iport) {
		host = ihost;
		port = iport;
	}

	public Class<?> findClass(String className) {
		try {
			Socket s = new Socket(host, port);
			// enter text here
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
