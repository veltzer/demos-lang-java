package designpatterns.exercises.factory.reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * Following the factory design pattern, this class allows for objects of
 * Signaller type. Creation is performed via reflection, and using system
 * properties to determine the desired type.
 */
public abstract class SignalFactory {
	public SignalFactory() {
		super();
	}

	public static Signaller createSignaller() {
		String signallerClassName = System.getProperty("factory.signaller",
				"FlashSignaller");

		String packageName = SignalFactory.class.getPackage().getName();
		signallerClassName = packageName + "." + signallerClassName;

		try {
			Class<?> signallerClass = Class.forName(signallerClassName);
			Object instance = null;
			try {
				instance = signallerClass.getDeclaredConstructor().newInstance();
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
			return (Signaller) instance;
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		try {
			Signaller signaller = createSignaller();
			signaller.signal();
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
