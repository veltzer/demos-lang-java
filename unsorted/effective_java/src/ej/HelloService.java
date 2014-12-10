package ej;

/**
 * @author: Yardena
 * @date: Sep 20, 2008 7:24:38 PM
 */
@DefaultTo(HelloServiceImpl.class)
public interface HelloService {
   void sayHello(String name);
   void sayGoodbye();
}
