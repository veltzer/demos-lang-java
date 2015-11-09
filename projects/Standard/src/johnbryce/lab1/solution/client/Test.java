package johnbryce.lab1.solution.client;

public class Test {

	public static void main(String[] args) {
		RemoteClassLoader loader=new RemoteClassLoader("127.0.0.1",5555);
		try {
			loader.loadClass("RemoteClass").newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
