package synchronization;

public class Synchronization {

    private  int count = 0;

    public void myRun(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }

    /*
        synchronized keyword allows one thread to access a particular section of code
     */
    public synchronized void increment(){
        count++;
    }


    public static void main(String[] args) {

        Synchronization sync = new Synchronization();
        sync.myRun();
    }
}