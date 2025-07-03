package ThreadExecutors.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

    public void main(String args[]){

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("Executing every 3 seconds");
        },0, 3, TimeUnit.SECONDS);
    }
}
