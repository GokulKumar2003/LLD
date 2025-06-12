package org.example.SynchronizedBlock;

/* This demo is to understand synchronization block */
public class SynchronizationDemo {

    private static int counter;
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
            counter++;
//        }
    }
    public static class Thread1 implements Runnable{

        public void run(){
            for(int i=0;i<1000000;i++){
                increment();
            }
        }
    }

    public static class Thread2 implements Runnable{

        public void run(){
            for(int i=0;i<1000000;i++){
                increment();
            }
        }
    }
}


