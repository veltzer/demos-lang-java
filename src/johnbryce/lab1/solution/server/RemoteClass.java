package johnbryce.lab1.solution.server;

public class RemoteClass {
	static {
		System.out.println("Hi ! I'm loaded !");
	}

	@SuppressWarnings("this-escape")
	public RemoteClass() {
		aMethod();
	}

	public void aMethod() {
		System.out.println("And I can even work now !");
	}
}
