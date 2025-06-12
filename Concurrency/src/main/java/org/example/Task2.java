package org.example;

public class Task2 extends Thread{

    private SharedResource sharedResource;
    private int val;

    public Task2(SharedResource sharedResource, int val){
        this.sharedResource = sharedResource;
        this.val = val;
    }

    public void run(){
        sharedResource.decCounter(val);
    }

}
