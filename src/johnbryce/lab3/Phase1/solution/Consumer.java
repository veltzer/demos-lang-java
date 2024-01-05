package johnbryce.lab3.Phase1.solution;

public class Consumer implements Runnable {
	private String consumerId;
	private Stack s;

	public Consumer(String iconsumerId, Stack is) {
		consumerId = iconsumerId;
		s = is;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			long sleepTime = (long) (Math.random() * 1500 + 500);
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
			s.pop();
		}
	}
}
