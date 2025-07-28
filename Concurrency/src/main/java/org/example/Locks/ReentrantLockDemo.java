package org.example.Locks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private int seats = 1;
    private final ReentrantLock lock = new ReentrantLock();

    public void bookTicket(String user){
        System.out.println(user + " is trying to book ticket");
        lock.lock();
        try{
            System.out.println(user + " acquired lock");
            if(seats > 0){
                seats -= 1;
                System.out.println(user + " booked seat successfully");
            }
            else{
                System.out.println("Sold out");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }
}

class ExpiringReentrantLock {
    private int seats = 1;
    private final ReentrantLock lock = new ReentrantLock();

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();
    private volatile boolean isLocked = false;
    
}

class Main {
    public static void main(String args[]){
        ReentrantLockDemo demo = new ReentrantLockDemo();

        Thread user1 = new Thread(()->demo.bookTicket("User1"));
        Thread user2 = new Thread(()->demo.bookTicket("User2"));

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

