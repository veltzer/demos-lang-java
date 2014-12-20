package effective_java;

public class RegistryTest {

  public void greetFormally(String surname) {
    HelloService serv   = Registry.get(HelloService.class);
    serv.sayHello("Sir " + surname);
  }

  public static void main(String[] str) {
    Registry.set(HelloService.class, new HelloServiceImpl());
//    HelloService mockHelloService = new HelloService() {
//      public void sayHello(String name) {
//        assert("Sir Smith".equals(name));
//      }
//      public void sayGoodbye() { }
//    };
//    Registry.set(HelloService.class, mockHelloService);
    new RegistryTest().greetFormally("Smith");
  }


}
