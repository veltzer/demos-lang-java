package designpatterns.exercises.singleton;

public final class SingletonEasy {
	private static SingletonEasy instance = new SingletonEasy();

	private SingletonEasy() {
		System.out.println("Singleton created");
	}

	public static SingletonEasy getInstance() {
		return instance;
	}
}
