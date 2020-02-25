package synchronization;

import java.util.Scanner;

public class VolatileExample extends Thread {

    /*
        Each thread caches the values of variables from the memory,which means that the variable in the memory can change but
        the variable inside the cache doesn't, this leads to inconsistency.

        The volatile keyword prevents this from happening, it guarantees that any thread that reads a certain variable will
        see the most recently written value
     */
    private volatile boolean running = true;
    private int counter = 0;

    @Override
    public void run() {
        while (running){
            System.out.println(counter++);

            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void close(){
        running = false;
    }

    public static void main(String[] args) {
        VolatileExample thread = new VolatileExample();
        System.out.println("press enter to stop! ");

        thread.start();




        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread.close();


    }
}
