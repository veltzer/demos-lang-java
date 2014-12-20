package java_five_exercises.varargs_boxing;

public abstract class PerformaceTest implements Test {
    public final static long TIMES=1000000;

    public void run() {
        init();
        long time = -System.nanoTime();
        for (int i=0;i<TIMES;i++)
            cycle();
        time += System.nanoTime();
        done();
        System.out.format("%-50sduration %f%n", this.getClass().getName(), (double)time/TIMES);
    }

    public abstract void init();
    public abstract void cycle();
    public abstract void done();
}