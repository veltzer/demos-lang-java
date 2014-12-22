package effectivejava.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementing Service Locator pattern using HTC
 * http://martinfowler.com/articles/injection.html#UsingAServiceLocator
 */
public abstract class AutoRegistry {
	private static final ConcurrentMap<Class<?>, Object> SERVICES =
			new ConcurrentHashMap<Class<?>, Object>();
	/**
	 * Acquire an implementation of a service. If one has not already
	 * been instantiated, instantiate the class defined by the
	 * Implementor annotation on the interface
	 */
	public static <T> T get(Class<T> interfaceClass) {
		assert interfaceClass != null;
		Object service = SERVICES.get(interfaceClass);
		//initialization tricks
		if (service == null) {
			Builder<T> b1=new AnnotationBuilder<T>(interfaceClass);
			Builder<T> b2=new LoaderBuilder<T>(interfaceClass);
			Collection<Builder<T>> a=new ArrayList<Builder<T>>();
			a.add(b1);
			a.add(b2);
			T temp = getFirstNotNull(a);
			if (temp == null) {
				return null;
			}
			service = SERVICES.putIfAbsent(interfaceClass, temp);
			if (service == null) {
				return temp;
			}
		}
		return interfaceClass.cast(service);
	}

	/**
	 * Set an alternate service implementation.
	 * Typically only called in unit tests.
	 */
	public static <T> void set(Class<T> interfaceClass, T provider) {
		assert provider != null;
		assert interfaceClass != null;
		SERVICES.put(interfaceClass, interfaceClass.cast(provider));
	}

	static class AnnotationBuilder<T> implements Builder<T> {
		private final Class<T> intf;
		AnnotationBuilder(Class<T> iintf) {
			intf = iintf;
		}
		public T build() {
			DefaultTo to = intf.getAnnotation(DefaultTo.class);
			if (to == null) {
				return null;
			}
			Class<?> implementingClass = to.value();
			try {
				return intf.cast(implementingClass.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	static class LoaderBuilder<T> implements Builder<T> {
		private final Class<T> intf;
		LoaderBuilder(Class<T> iintf) {
			intf = iintf;
		}
		public T build() {
			ServiceLoader<T> loader = ServiceLoader.load(intf);
			if (loader == null) {
				return null;
			}
			Iterator<T> iterator = loader.iterator();
			if (!iterator.hasNext()) {
				return null;
			}
			return loader.iterator().next();
		}
	}
	private static <T> T getFirstNotNull(Collection<Builder<T>> builders) {
		for (Builder<T> builder: builders) {
			T temp = builder.build();
			if (temp != null) {
				return temp;
			}
		}
		return null;
	}
}
