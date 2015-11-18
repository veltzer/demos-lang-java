public abstract class Area {
	static final long ITERATIONS = 5000000000L;
	static final long NANOS_PER_MS = (1000L * 1000L);
	static final StringBuilder SB = new StringBuilder();

	private static void printStats(String s, long n, long elapsedTime) {
		float millis = elapsedTime / NANOS_PER_MS;
		float rate = 0;
		if (millis != 0) {
			rate = n / millis;
		}
		System.out.println(s + ": Elapsed time in ms -> " + millis);
		System.out.println(s + ": Iterations per ms --> " + rate);
	}

	private static long doTest(String str, Shape s, long n) {
		double area = 0;
		long start = System.nanoTime();
		for (long i = 0; i < n; i++) {
			area = s.area();
		}
		long elapsedTime = System.nanoTime() - start;
		SB.append(str).append(area);
		System.out.println(SB.toString());
		SB.setLength(0);
		return elapsedTime;
	}

	public static void main(String[] args) {
		String areaStr = "	Area: ";
		Shape s = new Square(25.33);
		Shape r = new Rectangle(20.75, 30.25);
		Shape rt = new RightTriangle(20.50, 30.25);

		System.out.println("Warming up ...");
		long elapsedTime = doTest(areaStr, s, ITERATIONS);
		printStats("	Square", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, r, ITERATIONS);
		printStats("	Rectangle", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, rt, ITERATIONS);
		printStats("	Right Triangle", ITERATIONS, elapsedTime);
		System.out.println("1st warmup done.");

		System.out.println("Starting 2nd warmup ...");
		elapsedTime = doTest(areaStr, s, ITERATIONS);
		printStats("	Square", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, r, ITERATIONS);
		printStats("	Rectangle", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, rt, ITERATIONS);
		printStats("	Right Triangle", ITERATIONS, elapsedTime);
		System.out.println("2nd warmup done.");

		System.out.println("Starting measurement intervals ...");
		elapsedTime = doTest(areaStr, s, ITERATIONS);
		printStats("	Square", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, r, ITERATIONS);
		printStats("	Rectangle", ITERATIONS, elapsedTime);
		elapsedTime = doTest(areaStr, rt, ITERATIONS);
		printStats("	Right Triangle", ITERATIONS, elapsedTime);
		System.out.println("Measurement intervals done.");
	}
}
