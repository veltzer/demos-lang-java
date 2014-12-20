package effective_java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementing Service Locator pattern
 * http://martinfowler.com/articles/injection.html#UsingAServiceLocator
 */
public class Registry {
  private final static Map<Class<?>, Object> services =
      new ConcurrentHashMap<Class<?>, Object>();

  /**
   * Acquire an implementation of a service.
   */
  public static <T> T get(Class<T> interfaceClass) {
    assert(interfaceClass != null);
    return interfaceClass.cast(services.get(interfaceClass));
  }

  /**
   * Set a service implementation.
   */
  public static <T> void set(Class<T> interfaceClass, T provider) {
    assert(interfaceClass != null);
    assert(interfaceClass.isInterface());
    services.put(interfaceClass, interfaceClass.cast(provider));
  }

}
