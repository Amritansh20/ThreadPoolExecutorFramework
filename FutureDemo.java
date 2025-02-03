import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());


        //use case -1
        Future<?> futureObj = executor.submit(()->{
            System.out.println("Task 1 with runnalbe");
        });

        try{
            Object obj = futureObj.get(); // Since there is no return type in runnable. It can be anything which can only be caught in Obj.
            System.out.println(futureObj==null); // It is only of type Runnable and it always returns null
        }catch (Exception e){

        }

        //usecase-2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj2= executor.submit(()->{
            output.add(100);
            System.out.println("Task 2 with runnable with two params (Runnable and result ) and return obj");
        },output);
     }
}
