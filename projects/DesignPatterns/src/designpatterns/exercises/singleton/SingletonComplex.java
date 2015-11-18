package designpatterns.exercises.singleton;

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
				newobj = Class.forName(classname).newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			hash.put(classname, newobj);
		}
		return hash.get(classname);
	}
}
