package ThreadExecutors.FixedThreadPool;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class FixedThreadPoolDemo {

    public void main(String args[]) throws Exception{

        ExecutorService service = Executors.newFixedThreadPool(5);

        for(int i=0;i<10;i++){
            service.execute(new T1());
        }

        for(int i=0;i<10;i++){
            Future<Integer> future = service.submit(new T2());
            System.out.println((Integer)future.get());
        }

        service.shutdown();
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

    public class T2 implements Callable<Integer>{

        @Override
        public Integer call(){
            try{
                sleep(2000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("Task executed by: " + Thread.currentThread().getName());
            return Integer.valueOf(10);
        }
    }
}
