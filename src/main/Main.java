package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author rido
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{

        BlockingQueue<Long> s1 = new ArrayBlockingQueue<>(11);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue<>(11);

        boolean status = true;

        s1.add(new Long(4));
        s1.add(new Long(5));
        s1.add(new Long(8));
        s1.add(new Long(12));
        s1.add(new Long(21));
        s1.add(new Long(22));
        s1.add(new Long(34));
        s1.add(new Long(35));
        s1.add(new Long(36));
        s1.add(new Long(37));
        s1.add(new Long(42));

        Producer p1 = new Producer(s1, s2, status);
        Producer p2 = new Producer(s1, s2, status);
        Producer p3 = new Producer(s1, s2, status);
        Producer p4 = new Producer(s1, s2, status);

        p1.start();
        p2.start();
        p3.start();
        p4.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();

        Consumer con = new Consumer(s2);
        con.start();

    }
        
}
    

