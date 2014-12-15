/*
 * Queue.java
 *
 * Created on April 16, 2005, 7:36 AM
 */

import java.util.Vector;

/**
 *
 * @author huntch
 */
public class Queue {
    private Vector itsBuffers = new Vector();
    private int itsEnqueueCount = 0;
    private int itsDequeueCount = 0;
    private int itsMaxDepth = 300;    // overall size
    private int itsMaxOpDepth;       // the maximum depth reached during execution
    private boolean itsMaxReached;
    
    public Queue(int theDepth) {
        itsMaxDepth = theDepth;
        itsMaxOpDepth = 0;
        itsMaxReached = false;
    }
    
    // add theObject to the queue, if there
    // no objects on the queue, then notify
    // that there is one now
    synchronized public void enqueue(Object theObject) throws InterruptedException {
        if (itsBuffers.size() == 0) {
            // System.err.println("Notifying thread...");
            notifyAll();
        }
        
        while (itsBuffers.size() >= itsMaxDepth) {
            // have to block til it is smaller than allowable depth
            System.err.println("Hit max queue depth, blocking thread (" + Thread.currentThread().getName() + ")...");
            itsMaxReached = true;
            wait();
        }
        
        itsBuffers.addElement(theObject);
        itsEnqueueCount++;
        
        // track the operational maximum depth reached
        if (itsBuffers.size() > itsMaxOpDepth)
            itsMaxOpDepth = itsBuffers.size();
    }
    
    // if there's an item on the queue, then
    // process it. If not, go to sleep and
    // wait for a notify.
    synchronized public Object dequeue() throws InterruptedException {
        while (itsBuffers.size() == 0) {
            //System.err.println("Waiting on empty queue...");
            wait();
            //System.err.println("Wait on queue done...");
        }
        
        if (itsMaxReached) {
            // notify writer it can write
            notifyAll();
            itsMaxReached = false;
            System.err.println("Thread ("+ Thread.currentThread().getName() + ") read on max queue depth...");
        }
        
        Object firstItem = itsBuffers.elementAt(0);
        itsBuffers.removeElementAt(0);
        itsDequeueCount++;
        
        return firstItem;
    }
    
    // get the count of Items dequeue'd
    synchronized public int getDequeuedCount() {
        return itsDequeueCount;
    }
    
    // get the count of Items enqueued
    synchronized public int getEnqueuedCount() {
        return itsEnqueueCount;
    }
    
    
    synchronized public int getMaxOperationalDepth() {
        return itsMaxOpDepth;
    }
}
