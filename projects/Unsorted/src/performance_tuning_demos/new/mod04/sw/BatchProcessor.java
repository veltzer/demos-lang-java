package foo;

public class BatchProcessor {
	final private static int DEFAULT_TEST_TIME = 90;
	final private static int DEFAULT_NUMBER_OF_READERS = 40;
	final private static int DEFAULT_NUMBER_OF_WRITERS = 30;
	final private static int DEFAULT_MAX_QUEUE_DEPTH = 15000;
	private static int hiSrvTimeW = 50;
	private static int loSrvTimeW = 8;
	private static int hiSrvTimeR = 50;
	private static int loSrvTimeR = 8;
	private static Queue itsQueue = null;
	private static ReadThread readThreads[] = null;
	private static WriteThread writeThreads[] = null;

	static private void printUsage() {
		System.err.println("Usage: java [-DhighServiceTimeW=r] [-DlowServiceTimeW=s] [-DhighServiceTimeR=t] [-DlowServiceTimeR=u] [-DreaderThreads=w] [-DwriterThreads=x] [-DqueueDepth=y] [-DtestTime=z] BatchProcessor [-help]");
		System.err.println("\tr is the upper bound on the writer service time in ms, default = " + hiSrvTimeW);
		System.err.println("\ts is the lower bound on the writer service time in ms, default = " + loSrvTimeW);
		System.err.println("\tt is the upper bound on the reader service time in ms, default = " + hiSrvTimeR);
		System.err.println("\tu is the lower bound on the reader service time in ms, default = " + loSrvTimeR);
		System.err.println("\tw is number of reader threads to run, default = " + DEFAULT_NUMBER_OF_READERS);
		System.err.println("\tx is number of writer threads to run, default = " + DEFAULT_NUMBER_OF_WRITERS);
		System.err.println("\ty is the queue depth, default = " + DEFAULT_MAX_QUEUE_DEPTH);
		System.err.println("\tz is the length of time to run test in seconds, default = " + DEFAULT_TEST_TIME);
		System.err.println("\t-help prints this message");
	}

	private static void runReaderWriterThreads(int theNumberOfWriters, int theNumberOfReaders,
			int hiSrvTimeR, int loSrvTimeR, int hiSrvTimeW, int loSrvTimeW) {

		readThreads = new ReadThread[theNumberOfReaders];
		writeThreads = new WriteThread[theNumberOfWriters];

		for (int x = 0; x < theNumberOfReaders; x++) {
			readThreads[x] = new ReadThread(itsQueue);
			readThreads[x].setName("Read Thread-" + (x+1));
		}

		for (int y = 0; y < theNumberOfWriters; y++) {
			writeThreads[y] = new WriteThread(itsQueue,hiSrvTimeR,loSrvTimeR,hiSrvTimeW,loSrvTimeW);
			writeThreads[y].setName("Writer Thread-" + (y+1));
		}

		// start the threads
		for (int z = 0, a = 0; a < theNumberOfWriters || z < theNumberOfReaders; a++, z++) {
			if (a < theNumberOfWriters) {
				//System.err.println("Starting " + Thread.currentThread().getName() + " writer thread (" + x + ")...");
				writeThreads[a].start();
			}
			if (z < theNumberOfReaders) {
				//System.err.println("Starting " + Thread.currentThread().getName() + " reader thread (" + y + ")...");
				readThreads[z].start();
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("-help")) {
				printUsage();
				System.exit(-1);
			}
		}

		String hiSrvTimeWStr = System.getProperty("highServiceTimeW");

		if (hiSrvTimeWStr != null) {
			Integer hiSrvTimeWInt = new Integer(hiSrvTimeWStr);
			hiSrvTimeW = hiSrvTimeWInt.intValue();
		}

		String loSrvTimeWStr = System.getProperty("lowServiceTimeW");

		if (loSrvTimeWStr != null) {
			Integer loSrvTimeWInt = new Integer(loSrvTimeWStr);
			loSrvTimeW = loSrvTimeWInt.intValue();
		}

		String hiSrvTimeRStr = System.getProperty("highServiceTimeR");

		if (hiSrvTimeRStr != null) {
			Integer hiSrvTimeRInt = new Integer(hiSrvTimeRStr);
			hiSrvTimeR = hiSrvTimeRInt.intValue();
		}

		String loSrvTimeRStr = System.getProperty("lowServiceTimeR");

		if (loSrvTimeRStr != null) {
			Integer loSrvTimeRInt = new Integer(loSrvTimeRStr);
			loSrvTimeR = loSrvTimeRInt.intValue();
		}

		String readerThreadsStr = System.getProperty("readerThreads");
		int readerThreads = DEFAULT_NUMBER_OF_READERS;
		if (readerThreadsStr != null) {
			Integer readerThreadsInt = new Integer(readerThreadsStr);
			readerThreads = readerThreadsInt.intValue();
		}

		String writerThreadsStr = System.getProperty("writerThreads");
		int writerThreads = DEFAULT_NUMBER_OF_WRITERS;
		if (writerThreadsStr != null) {
			Integer writerThreadsInt = new Integer(writerThreadsStr);
			writerThreads = writerThreadsInt.intValue();
		}

		String queueDepthStr = System.getProperty("queueDepth");
		int queueDepth = DEFAULT_MAX_QUEUE_DEPTH;
		if (queueDepthStr != null) {
			Integer queueDepthInt = new Integer(queueDepthStr);
			queueDepth = queueDepthInt.intValue();
		}

		String testTimeStr = System.getProperty("testTime");
		int testTime = DEFAULT_TEST_TIME; // default test time
		if (testTimeStr != null) {
			Integer testTimeInt = new Integer(testTimeStr);
			testTime = testTimeInt.intValue();
		}

		System.err.println("Starting (" + readerThreads + ") reader threads on 'read' side of the queue...");
		System.err.println("Starting (" + writerThreads + ") writer threads on 'write' side of the queue...");
		System.err.println("Reader threads service times range is between (" + loSrvTimeR + ") and (" + hiSrvTimeR + ") ms...");
		System.err.println("Writer threads service times range is between (" + loSrvTimeW + ") and (" + hiSrvTimeW + ") ms...");
		System.err.println("Setting the queue depth to (" + queueDepth + ")...");
		System.err.println("Running the test for (" + testTime + ") seconds...");

		// create the reader / writer queue
		itsQueue = new Queue(queueDepth);

		// create & start reader / writer threads
		runReaderWriterThreads(writerThreads, readerThreads, hiSrvTimeR, loSrvTimeR, hiSrvTimeW, loSrvTimeW);

		try {
			Thread.sleep(testTime*1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		// calculate the stats
		int totalDequeueCount = 0;
		int totalEnqueueCount = 0;
		totalDequeueCount = itsQueue.getDequeuedCount();
		totalEnqueueCount = itsQueue.getEnqueuedCount();

		float enqueueRate = totalEnqueueCount/testTime;
		float dequeueRate = totalDequeueCount/testTime;
		System.err.println();
		System.err.println("Maximum queue depth reached on Queue: " + itsQueue.getMaxOperationalDepth());
		System.err.println("Total number of items enqueued: " + totalEnqueueCount);
		System.err.println("Total number of items dequeued: " + totalDequeueCount);
		System.err.println("Enqueued rate: " + enqueueRate + "/sec");
		System.err.println("Deqeueud rate: " + dequeueRate + "/sec");

		System.exit(0);
	}
}
