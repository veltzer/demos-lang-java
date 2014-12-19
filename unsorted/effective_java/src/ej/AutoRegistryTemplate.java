package ej;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementing Service Locator pattern using HTC
 * http://martinfowler.com/articles/injection.html#UsingAServiceLocator
 * @date: Sep 20, 2008 1:47:03 PM
 */
public class AutoRegistryTemplate {
  private final static ConcurrentMap<Class<?>, Object> services = null;//todo

  /**
   * Acquire an implementation of a service. If one has not already
   * been instantiated, instantiate the class defined by the
   * DefaultTo annotation on the interface
   */
  public static <T> T get(Class<T> interfaceClass) {
    assert(interfaceClass != null);
    Object service = services.get(interfaceClass);
    //initialization
    if (service == null) {
      //todo
    }
    return interfaceClass.cast(service);
  }

  /**
   * Set an alternate service implementation.
   * Typically only called in unit tests.
   */
  public static <T> void set(Class<T> interfaceClass, T provider) {
    assert(provider != null);
    assert(interfaceClass != null);
    services.put(interfaceClass, interfaceClass.cast(provider));
  }

  static class AnnotationBuilder<T> implements Builder<T> {
    public T build() {
      return null; //todo
    }
  }
  static class LoaderBuilder<T> implements Builder<T> {
    final Class<T> intf;
    LoaderBuilder(Class<T> intf) {
      this.intf = intf;
    }
    public T build() {
      ServiceLoader<T> loader = ServiceLoader.load(intf);
      if (loader == null) return null;
      Iterator<T> iterator = loader.iterator();
      if (!iterator.hasNext()) return null;
      return loader.iterator().next();
    }
  }

  private static <T> T getFirstNotNull(Builder<T>... builders) {
    for (Builder<T> builder: builders) {
      T temp = builder.build();
      if (temp != null) return temp;
    }
    return null;
  }
}
