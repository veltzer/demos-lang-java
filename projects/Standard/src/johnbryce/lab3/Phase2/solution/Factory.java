package johnbryce.lab3.Phase2.solution;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Factory {
	public static void main(String[] args) {
		final Stack myStack = new Stack();
		ExecutorService executor = Executors.newCachedThreadPool();
		// ExecutorService executor=Executors.newFixedThreadPool(2);
		Callable<Integer> producer1 = new Producer<Integer>("Producer1",
				myStack);
		Callable<Integer> producer2 = new Producer<Integer>("Producer2",
				myStack);
		Callable<Integer> consumer1 = new Consumer<Integer>("Consumer1",
				myStack);
		Callable<Integer> consumer2 = new Consumer<Integer>("Consumer2",
				myStack);

		Collection<Callable<Integer>> col = new HashSet<Callable<Integer>>();
		col.add(producer1);
		col.add(producer2);
		col.add(consumer1);
		col.add(consumer2);
		try {
			executor.invokeAll(col);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		executor.shutdown();
	}
}
