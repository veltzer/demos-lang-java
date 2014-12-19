package helloworld.client;

import helloworld.client.proxy.*;

public class HelloWorldClient {

	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldService();
		HelloWorld port = service.getHelloWorldPort();

		String response = port.sayHello("hello");

		System.out.println(response);
	}
}
