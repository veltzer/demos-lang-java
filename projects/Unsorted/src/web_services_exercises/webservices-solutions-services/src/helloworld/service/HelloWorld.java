package helloworld.service;

@WebService
public class HelloWorld {
	public String sayHello(String name) {
		return "Hello, " + name;
	}
}
