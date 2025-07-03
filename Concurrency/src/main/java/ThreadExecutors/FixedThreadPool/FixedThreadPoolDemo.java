package ThreadExecutors.FixedThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class FixedThreadPoolDemo {

    public void main(String args[]) throws InterruptedException{

        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i=0;i<10;i++){
            service.execute(new T1());
        }
    }

    public class T1 implements Runnable{
        @Override
        public void run() {
            try{
                sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted exception");
            }
            System.out.println("Task executed by: " + Thread.currentThread().getName());
        }
    }
}
