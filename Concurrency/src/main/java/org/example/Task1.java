package org.example;

public class Task1 extends Thread{

    private SharedResource sharedResource;
    private int val;
    public Task1(SharedResource sharedResource, int val) throws InterruptedException{
        this.sharedResource = sharedResource;
        this.val = val;
    }
    public void run(){
        sharedResource.incCounter(val);
    }
}
