package core.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

/**
 * This demo explores the behavior of the interruption system for thread
 * interruption in Java. Conclusions: - A CPU intensive thread that never does
 * sleep, wait, IO or anything cannot be stopped using interruption (see thread
 * T1). - A thread that calls sleep or wait a lot will be stopped (see thread
 * T2). - A thread doing sleep or wait will be stopped IN MID SLEEP (see thread
 * T3). - A thread that does Socket listening and is stuck on it will not be
 * stopped (see thread T4). - A thread that does IO on standard input will not
 * be stopped (see thread T5). - Closing a stream will not stop a thread stuck
 * on it (see thread T6).
 */
public abstract class InterruptDemo {
	// This thread runs forever and always consumes CPU
	private static class T1 extends Thread {

		private volatile boolean over = false;

		@Override
		public void run() {
			try {
				double result = 0;
				while (!over) {
					double f = 1;
					result += Math.sin(f);
					f++;
					// This is to trick the smart ass
					// compiler and his annoying warnings
					if (over) {
						sleep(5);
					}
				}
				System.out.println("result is " + result);
			} catch (InterruptedException e) {
				System.out.println("T1 ending");
				// throw new RuntimeException(e);
			}
		}

	}

	// This thread does sleep (most of the time)
	private static class T2 extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("T2 ending");
				// throw new RuntimeException(e);
			}
		}
	}

	private static class T3 extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					sleep(1000000);
				}
			} catch (InterruptedException e) {
				System.out.println("T3 ending");
				// throw new RuntimeException(e);
			}
		}
	}

	private static class T4 extends Thread {
		@Override
		public void run() {
			ServerSocket s = null;
			try {
				s = new ServerSocket(4444);
				s.accept();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (s != null) {
						s.close();
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("T4 ending");
		}
	}

	private static class T5 extends Thread {
		@Override
		public void run() {
			System.out.print("Enter your name: ");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				br.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			System.out.println("T5 ending");
		}
	}

	private static class T6 extends Thread {
		@Override
		public void run() {
			try {
				System.in.read();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		Thread t3 = new T3();
		Thread t4 = new T4();
		Thread t5 = new T5();
		Thread t6 = new T6();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		// let the threads get started...
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		t4.interrupt();
		t5.interrupt();
		t6.interrupt();
		try {
			System.in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
