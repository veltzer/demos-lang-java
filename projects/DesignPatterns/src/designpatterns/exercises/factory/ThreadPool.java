package designpatterns.exercises.factory;

import java.util.EmptyStackException;
import java.util.Stack;

public final class ThreadPool {
	private Stack<PooledThread> threads;
	private static ThreadPool instance = new ThreadPool();

	private class PooledThread extends Thread {
		private Runnable runnableJob;

		public PooledThread(Runnable runnable) {
			runnableJob = runnable;
			start();
		}

		public synchronized void setRunnableJob(Runnable runnable) {
			if (runnable == null) {
				return;
			}
			runnableJob = runnable;
			notify();
		}

		public synchronized void run() {
			while (true) {
				try {
					// See if there's a job:
					if (runnableJob == null) {
						try {
							threads.push(this);
							wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					// The thread is notified only when it gets a new runnable job. So at this
					// point there is a valid runnable job!
					runnableJob.run();
					runnableJob = null;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private ThreadPool() {
		threads = new Stack<PooledThread>();
	}

	public void spawn(Runnable runnable) {
		try {
			// Try to get a pooled thread:
			PooledThread pooledThread = threads.pop();
			pooledThread.setRunnableJob(runnable);
		} catch (EmptyStackException e) {
			// No threads available.
			new PooledThread(runnable);
			// This code for demontsration only. It is usually not such a good idea to put
			// program logic into exception handling mechanism.
		}
	}

	public static ThreadPool getInstance() {
		return instance;
	}
}
