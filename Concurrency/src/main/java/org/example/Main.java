package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SharedResource sharedResource = new SharedResource();

        Thread[] threads = new Thread[200];

        for(int i=0;i<100;i++){
            threads[i] = new Thread(new Task1(sharedResource, 10));
            threads[i].start();
        }
        for(int i=100;i<200;i++){
            threads[i] = new Thread(new Task2(sharedResource, 10));
            threads[i].start();
        }

        for (int i = 0; i < 200; i++) {
            threads[i].join();
        }

        System.out.println("Counter: " + sharedResource.getCounter());
    }
}