package johnbryce.lab3.Phase2.solution;

import java.util.concurrent.Callable;

public class Consumer<T> implements Callable<Integer> {
	private String consumerId;
	private Stack s;

	public Consumer(String iconsumerId, Stack is) {
		consumerId = iconsumerId;
		s = is;
	}

	public Integer call() throws Exception {
		for (int i = 0; i < 20; i++) {
			long sleepTime = (long) (Math.random() * 1500 + 500);
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			s.pop();
		}
		return 0;
	}
}
