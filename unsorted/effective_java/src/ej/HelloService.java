package ej;

@DefaultTo(HelloServiceImpl.class)
public interface HelloService {
	void sayHello(String name);
	void sayGoodbye();
}
