package effective_java_exercises;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementing Service Locator pattern using HTC
 * http://martinfowler.com/articles/injection.html#UsingAServiceLocator
 */
public class AutoRegistry {
  private final static ConcurrentMap<Class<?>, Object> services =
      new ConcurrentHashMap<Class<?>, Object>();
  /**
   * Acquire an implementation of a service. If one has not already
   * been instantiated, instantiate the class defined by the
   * Implementor annotation on the interface
   */
  public static <T> T get(Class<T> interfaceClass) {
    assert(interfaceClass != null);
    Object service = services.get(interfaceClass);
    //initialization tricks
    if (service == null) {
      T temp = getFirstNotNull(
          new AnnotationBuilder<T>(interfaceClass),
          new LoaderBuilder<T>(interfaceClass));
      if (temp == null) return null;
      service = services.putIfAbsent(interfaceClass, temp);
      if (service == null) return temp;
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
    final Class<T> intf;
    AnnotationBuilder(Class<T> intf) {
      this.intf = intf;
    }
    public T build() {
      DefaultTo to = intf.getAnnotation(DefaultTo.class);
      if (to == null) return null;
      Class<?> implementingClass = to.value();
      try {
        return intf.cast(implementingClass.newInstance());
      } catch (Exception e) {
        return null;
      }
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
  @SafeVarargs
private static <T> T getFirstNotNull(Builder<T>... builders) {
    for (Builder<T> builder: builders) {
      T temp = builder.build();
      if (temp != null) return temp;
    }
    return null;
  }
}
