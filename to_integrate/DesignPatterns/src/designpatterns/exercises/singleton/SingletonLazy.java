package designpatterns.exercises.singleton;

public final class SingletonLazy {
	private static SingletonLazy instance;

	private SingletonLazy() {
		System.out.println("Singleton created");
	}

	public static synchronized SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}
