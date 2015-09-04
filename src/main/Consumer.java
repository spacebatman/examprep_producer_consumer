package main;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rido
 */

public class Consumer extends Thread{
   
    private BlockingQueue<Long> s2;

    public Consumer(BlockingQueue s2) {
        this.s2 = s2;

    }

    @Override
    public void run() {
        long sum = 0;
        long result;
 
        while (s2.peek() != null) {

            try {
                result = s2.take();
                sum += result;
                System.out.println("Consumer: " + result + " Sum = " + sum);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        System.out.println("Total sum: " + sum);
    }

    
}
