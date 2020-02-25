package threading;

import java.util.concurrent.*;

public class CallableThread implements Callable<Integer> {

    private int number;

    public CallableThread(int number){
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return number*number;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableThread thread = new CallableThread(5);
        Future<Integer> future = executorService.submit(thread);

        try{
            Integer squareNumber = future.get();
            System.out.println(squareNumber);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
