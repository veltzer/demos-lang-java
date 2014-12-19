package ej;

public class HelloServiceImpl implements HelloService {
	public HelloServiceImpl() {}
	public void sayHello(String name) {
		System.out.println("Hello, " + name);
	}
	public void sayGoodbye() {
		System.out.println("Goodbye");
	}
}
