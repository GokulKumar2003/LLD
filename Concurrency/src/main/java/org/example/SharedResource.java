package org.example;

public class SharedResource {

    private int counter;

    public void incCounter(int val){
        int temp = counter;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("inc..");
        this.counter = temp + val;
    }

    public void decCounter(int val){
        System.out.println("dec..");
        this.counter -= val;
    }

    public int getCounter(){
        return this.counter;
    }
}
