package designpatterns.exercises.factory.reflection;

/**
 * Following the factory design pattern, this class allows for objects of Signaller type.
 * Creation is performed via reflection, and using system properties to determine the desired type.
 */
public class SignalFactory {
	public SignalFactory() {
		super();
	}
	public static Signaller createSignaller() {
		String signallerClassName = System.getProperty("factory.signaller", "FlashSignaller");

		String packageName = SignalFactory.class.getPackage().getName();
		signallerClassName = packageName + "." + signallerClassName;

		try {
			Class<?> signallerClass = Class.forName(signallerClassName);
			Object instance = signallerClass.newInstance();
			return (Signaller) instance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			Signaller signaller = createSignaller();
			signaller.signal();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
