package threading;

public class RunnableInterface implements Runnable {

    /*
        everything inside the method run will be executed on the background thread
     */
    @Override
    public void run(){

        /*
         currently executing thread
         */
     //   System.out.println(Thread.currentThread());

       for(int i=0;i<5;i++) {
           System.out.println("New thread by implementing runnable");
           try{
               Thread.sleep(1000);
           }
           catch(Exception e){
               e.printStackTrace();
           }
       }


    }


    public static void main(String[] args) {
        /*
         thread initialization
         */
        Thread thread = new Thread(new RunnableInterface());

        /*
         start() - actually created a new thread
         run() - calls run on the current thread (main thread)
         */
        thread.start();



    }
}
