package ej;

/**
 * @date: Sep 20, 2008 7:25:14 PM
 */
public class HelloServiceImpl implements HelloService {

  public HelloServiceImpl() {}

  public void sayHello(String name) {
    System.out.println("Hello, " + name);
  }
  public void sayGoodbye() {
    System.out.println("Goodbye");
  }
}
