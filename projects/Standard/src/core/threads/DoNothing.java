package core.threads;

/**
 * This example shows that the implementation of Java is really shitty.
 * Run this app and strace it with strace -f java -classpath [...] [class]
 * and see that there are threads in java who bother the system every so and so
 * mili seconds.
 * Also note that Java creates 18 threads at the OS level and not just 1. 18!
 * Fuck them!
 */
public abstract class DoNothing {
	public static void main(String[] args) {
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
