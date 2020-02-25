package threading;

public class AnonymousThread {


    public static void main(String[] args) {
        Thread thread = new Thread("Thread"){

            @Override
            public void run() {
                System.out.println("Anonymous thread started");
            }
        };
        thread.start();
    }
}
