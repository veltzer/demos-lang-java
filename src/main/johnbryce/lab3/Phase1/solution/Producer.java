package johnbryce.lab3.Phase1.solution;

public class Producer implements Runnable {
	private String producerId;
	private Stack s;

	public Producer(String iproducerId, Stack is) {
		producerId = iproducerId;
		s = is;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep((long) Math.random() * 1500 + 500);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			s.push(i);
		}
	}
}
