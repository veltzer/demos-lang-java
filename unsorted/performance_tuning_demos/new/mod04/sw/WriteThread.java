/*
 * WriteThread.java
 *
 * Created on April 16, 2005, 7:39 AM
 */

import java.util.Random;

/**
 *
 * @author huntch
 */
public class WriteThread extends Thread{
    private Random itsRandom;
    private Queue itsQueue;
    private int itsHiSrvTimeR;
    private int itsLoSrvTimeR;
    private int itsHiSrvTimeW;
    private int itsLoSrvTimeW;
    
    public WriteThread(Queue theQueue, int theHiSrvTimeR, int theLoSrvTimeR, int theHiSrvTimeW, int theLoSrvTimeW) {
        itsRandom = new Random();
        itsQueue = theQueue;
        itsHiSrvTimeR = theHiSrvTimeR;
        itsLoSrvTimeR = theLoSrvTimeR;
        itsHiSrvTimeW = theHiSrvTimeW;
        itsLoSrvTimeW = theLoSrvTimeW;
    }
    
    @Override
    public void run() {
        for (;;) {
            // calculate a random number for reader thread service time
            // itsHiSrvTimeR is the upper bound on the reader service time
            // itsLoSrvTimeR is the lower bound on the reader service time
            int waitTime = itsRandom.nextInt(itsHiSrvTimeR-itsLoSrvTimeR) + itsLoSrvTimeR;
            // System.err.println("Reader servicing time = " + waitTime);
            //System.err.println("Creating item...");
            try { Thread.sleep(waitTime);} catch (InterruptedException ex) {ex.printStackTrace();}
            // calculate a random service time for the WriteThread and put it on the queue
            // itHiSrvTimeW is the upper bound on the writer service time
            // itLoSrvTimeW is the lower bound on the writer service time
            int writerWorkTime = itsRandom.nextInt(itsHiSrvTimeW-itsLoSrvTimeW) + itsLoSrvTimeW;
            // System.err.println("Writer servicing time = " + writerWorkTime);
            Integer writerWorkTimeInt = new Integer(writerWorkTime);
            //System.err.println("Putting an item on the queue...");
            putWorkItemOnQueue(writerWorkTimeInt);
            
        }
    }
    
    private void putWorkItemOnQueue(Integer theItem) {
        try {
            itsQueue.enqueue(theItem);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
