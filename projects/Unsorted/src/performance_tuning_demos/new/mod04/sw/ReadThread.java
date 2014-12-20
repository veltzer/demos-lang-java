package foo;

public class ReadThread extends Thread {
    final private static int DEFAULT_SLEEP_TIME = 10;
    private Queue itsQueue;

    public ReadThread(Queue theQueue) {
        itsQueue = theQueue;
    }

    @Override
    public void run() {
        for (;;) {
            //System.err.println("Getting an item from the queue...");
            Integer workTime = (Integer)getWorkItemFromQueue();
            //System.err.println("Processing item from queue...");
            doWorkOnItem(workTime);
        }
    }

    private Object getWorkItemFromQueue() {
        Object workItem = null;
        try {
            workItem = itsQueue.dequeue();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return workItem;
    }

    private void doWorkOnItem(Integer theTimeToWork) {
        int workTime = theTimeToWork.intValue();

        // simulate execute time
        long curTime = System.currentTimeMillis();
        long elapsedTime, laterTime = 0;
        int iteration = 1;
        do
        {
            // simulate blocking/waiting time on
            // every 5th time through here
            if (iteration++ % 2000 == 0) { //System.err.println("Sleeping...");
                try {
                    Thread.sleep(DEFAULT_SLEEP_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            laterTime = System.currentTimeMillis();
            elapsedTime = laterTime - curTime;
        }
        while (workTime > elapsedTime);
    }
}
