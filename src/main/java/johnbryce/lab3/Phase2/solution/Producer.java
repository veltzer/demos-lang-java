package johnbryce.lab3.Phase2.solution;

import java.util.concurrent.Callable;

public class Producer<T> implements Callable<Integer> {
	private String producerId;
	private Stack s;

	public Producer(String iproducerId, Stack is) {
		producerId = iproducerId;
		s = is;
	}

	public Integer call() throws Exception {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep((long) Math.random() * 1500 + 500);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			s.push(i);
		}
		return 0;
	}
}
