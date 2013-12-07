package core.threads;

import java.util.Random;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * This example shows that read/write reordering can happen in Java too...:)
 * This example doesn't work probably because of affinity issues.
 *
 * @author mark
 */

abstract class ReadWriteReordering {
	private static CyclicBarrier b = new CyclicBarrier(3);
	private static final int COUNT = 40000;
	private static int x, y, r1, r2;

	private static class FirstThread extends Thread {
		@Override
		public void run() {
			int mycount = COUNT;
			Random r = new Random();
			while (mycount > 0) {
				try {
					int rint = r.nextInt() % 10;
					b.await();
					while (rint > 0) { rint--; }
					x = 1;
					r1 = y;
					b.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} catch (BrokenBarrierException e) {
					throw new RuntimeException(e);
				}
				mycount--;
				//System.out.println("count 1 is "+mycount);
			}
			System.out.println("thread 1 terminated");
		}
	}

	private static class SecondThread extends Thread {
		@Override
		public void run() {
			int mycount = COUNT;
			Random r = new Random();
			while (mycount > 0) {
				try {
					int rint = r.nextInt() % 10;
					b.await();
					while (rint > 0) { rint--; }
					y = 1;
					r2 = x;
					b.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} catch (BrokenBarrierException e) {
					throw new RuntimeException(e);
				}
				mycount--;
				//System.out.println("count 2 is "+mycount);
			}
			System.out.println("thread 2 terminated");
		}
	}

	public static void main(String[] args) {
		Thread firstThread = new FirstThread();
		Thread secondThread = new SecondThread();
		firstThread.start();
		secondThread.start();
		int mycount = COUNT;
		int errors = 0;
		while (mycount > 0) {
			x = 0;
			y = 0;
			try {
				b.await();
				b.await();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} catch (BrokenBarrierException e) {
				throw new RuntimeException(e);
			}
			if (r1 == 0 && r2 == 0) {
				errors++;
			}
			mycount--;
			//System.out.println("main count is "+mycount);
		}
		// print the results
		System.out.println("number of errors is " + errors);
		/*
		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		*/
	}
}
