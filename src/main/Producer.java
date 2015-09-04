package main;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rido
 */

public class Producer extends Thread{
    
    BlockingQueue<Long> s1;
    BlockingQueue<Long> s2;
    
    boolean status;

    public Producer(BlockingQueue<Long> s1, BlockingQueue<Long> s2, boolean status) {

        this.s1 = s1;
        this.s2 = s2;
        this.status = status;

    }

    @Override
    public void run() {

        while (s1.peek() != null) {
            long tal;
            try {

                tal = fib(s1.poll());
                s2.put(tal);
                System.out.println("Producer " + tal);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
}
