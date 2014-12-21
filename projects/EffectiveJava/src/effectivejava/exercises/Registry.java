package effectivejava.exercises;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementing Service Locator pattern
 * http://martinfowler.com/articles/injection.html#UsingAServiceLocator
 */
public abstract class Registry {
  private static final Map<Class<?>, Object> SERVICES =
      new ConcurrentHashMap<Class<?>, Object>();

  /**
   * Acquire an implementation of a service.
   */
  public static <T> T get(Class<T> interfaceClass) {
    assert interfaceClass != null;
    return interfaceClass.cast(SERVICES.get(interfaceClass));
  }

  /**
   * Set a service implementation.
   */
  public static <T> void set(Class<T> interfaceClass, T provider) {
    assert interfaceClass != null;
    assert interfaceClass.isInterface();
    SERVICES.put(interfaceClass, interfaceClass.cast(provider));
  }

}
