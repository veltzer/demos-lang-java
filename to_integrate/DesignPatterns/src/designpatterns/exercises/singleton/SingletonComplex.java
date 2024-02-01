package designpatterns.exercises.singleton;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class SingletonComplex {
	private static HashMap<String, Object> hash = new HashMap<String, Object>();

	private SingletonComplex() {
		System.out.println("Singleton created");
	}

	public static synchronized Object getInstance(String classname) {
		if (!hash.containsKey(classname)) {
			// this actually runs a no argument constructor
			Object newobj;
			try {
				Class<?> c=Class.forName(classname);
				try {
					newobj = c.getDeclaredConstructor().newInstance();
					hash.put(classname, newobj);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e);
				}
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return hash.get(classname);
	}
}
