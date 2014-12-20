package designpatterns.exercises.factory.reflection;

public class FlashSignaller implements Signaller {
	public FlashSignaller() {
		super();
	}
	public void signal() {
		System.out.println("flashing");
	}
}
