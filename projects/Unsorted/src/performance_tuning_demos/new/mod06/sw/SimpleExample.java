public class SimpleExample {

    final private static long ITERATIONS = 5000000000L;
    final private static long WARMUP = 10000000L;
    final private static long NANOS_PER_MS = 1000L * 1000L;

    private static boolean equalsTest(String s) {
        boolean b = s.equals(s);
        return b;
    }

    private static long doTest(long n) {
        long start = System.nanoTime();
        for (long i = 0; i < n; i++) {
            equalsTest("ABC");
        }
        long end = System.nanoTime();
        return end - start;
    }

    private static void printStats(long n, long nanos) {
        float itrsPerMs = 0;
        float millis = nanos/NANOS_PER_MS;
        if (millis != 0) {
            itrsPerMs = n/(nanos/NANOS_PER_MS);
        }
        System.out.println("    Elapsed time in ms -> " + millis);
        System.out.println("    Iterations / ms ----> " + itrsPerMs);
    }

    public static void main(String[] args) {
        System.out.println("Warming up ...");

        long nanos = doTest(WARMUP);
        System.out.println("1st warm up done.");
        printStats(WARMUP, nanos);

        System.out.println("Starting 2nd warmup ...");
        nanos = doTest(WARMUP);
        System.out.println("2nd warm up done.");
        printStats(WARMUP, nanos);

        System.out.println("Starting measurement interval ...");
        nanos = doTest(ITERATIONS);
        System.out.println("Measurement interval done.");
        System.out.println("Test complete.");
        printStats(ITERATIONS, nanos);
    }
}
