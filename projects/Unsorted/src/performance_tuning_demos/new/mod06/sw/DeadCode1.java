public abstract class DeadCode1 {

	private static final long NANOS_PER_MS = 1000000L;
	private static final int NUMBER = 25;

	// Non-recursive Fibonacci calculator
	private static int calcFibonacci(int n) {
		int result = 1;
		int prev = -1;
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum = prev + result;
			prev = result;
			result = sum;
		}
		return result;
	}

	private static void doTest(long iterations) {
		long startTime = System.nanoTime();
		for (long i = 0; i < iterations; i++) {
			calcFibonacci(NUMBER);
		}
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("	Elapsed nanoseconds -> " + elapsedTime);
		float millis = elapsedTime / NANOS_PER_MS;
		float itrsPerMs = 0;
		if (millis != 0) {
			itrsPerMs = iterations / millis;
		}
		System.out.println("	Iterations per ms ---> " + itrsPerMs);
	}

	public static void main(String[] args) {
		System.out.println("Warming up ...");
		doTest(1000000L);
		System.out.println("Warmup done.");
		System.out.println("Starting measurement interval ...");
		doTest(900000000L);
		System.out.println("Measurement interval done.");
		System.out.println("Test completed.");
	}
}
