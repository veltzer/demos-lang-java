package helloworld.service;

import javax.jws.*;

@WebService
public class HelloWorld {
	public String sayHello(String name) {
		return "Hello, "+name;
	}
}
