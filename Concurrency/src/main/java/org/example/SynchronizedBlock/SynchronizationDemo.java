package org.example.SynchronizedBlock;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/* This demo is to understand synchronization block */
public class SynchronizationDemo {

    private static AtomicInteger counter = new AtomicInteger(0);
    private static Object lock = new Object();
    public static void main(String args[]) throws InterruptedException{

        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);

    }

    public static void increment(){
//        synchronized (lock){
            counter.getAndIncrement();
//        }
    }
    public static class Thread1 implements Runnable{

        public void run(){
            for(int i=0;i<10000000;i++){
                try{
                    sleep(1);
                }catch (InterruptedException e){
                    System.out.println("Interupted Exception");
                }
                increment();
            }
        }
    }

    public static class Thread2 implements Runnable{

        public void run(){
            for(int i=0;i<10000000;i++){
                increment();
            }
        }
    }
}


