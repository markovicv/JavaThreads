package threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable {

    private int id;

    public ThreadPool(int id){
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Started: "+id);
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("finished: "+id);
    }

    public static void main(String[] args) {
        /*
            creates a pool of threads that are already initialized, so you don't have to wait for JVM
            to create a new thread. You have 2 threads always ready to go
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executorService.submit(new ThreadPool(i));
        }
        executorService.shutdown();
        System.out.println("All tasks submitted");

        try{
            executorService.awaitTermination(1, TimeUnit.HOURS);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("All tasks finished");


    }
}
