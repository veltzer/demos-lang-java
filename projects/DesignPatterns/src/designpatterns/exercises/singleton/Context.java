package designpatterns.exercises.singleton;

public abstract class Context {
	public static void main(String[] args) {
		try {
			SingletonEasy s1 = SingletonEasy.getInstance();
			SingletonEasy s2 = SingletonEasy.getInstance();
			System.out.println("s1 is " + s1);
			System.out.println("s2 is " + s2);
			System.out.println("done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
