package client;


public class Test {

	public static void main(String[] args) {
		RemoteClassLoader loader=new RemoteClassLoader("127.0.0.1",5555);
		try {
			//enter text here
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
