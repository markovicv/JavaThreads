package threading;

public class ExtendingThread extends Thread{

    @Override
    public void run() {
        System.out.println("Creating my thread by extending the Thread class");
    }


    public static void main(String[] args) {
        ExtendingThread thread = new ExtendingThread();
        thread.start();

    }
}
