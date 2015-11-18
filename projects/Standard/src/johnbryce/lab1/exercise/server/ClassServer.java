package johnbryce.lab1.exercise.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class ClassServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5555);
		} catch (IOException e) {
			System.out.println("could not listen on 5555 port");
		}
		DataInputStream in = null;
		ObjectOutputStream out = null;
		String className = null;
		while (true) {
			Socket s;
			try {
				s = server.accept();
				in = new DataInputStream(s.getInputStream());
				out = new ObjectOutputStream(s.getOutputStream());
				className = in.readUTF();
			} catch (IOException e) {
				break;
				// throw new RuntimeException(e);
			}
			if (className != null) {
				int length = (int) (new File(className + ".class")).length();
				byte[] data = new byte[length];
				FileInputStream fileIn;
				try {
					fileIn = new FileInputStream(className + ".class");
					fileIn.read(data, 0, data.length);
					out.writeObject(data);
					out.close();
					in.close();
				} catch (IOException e) {
					try {
						out.writeObject(null);
					} catch (IOException e1) {
						throw new RuntimeException(e1);
					}
				}
			}
		}
		try {
			server.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
