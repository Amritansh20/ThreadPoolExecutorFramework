import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureWithObjReturn {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> output = new ArrayList<>();

        Future<List<Integer>> futureObj = executor.submit(new MyRunnable(output),output);

        try{
            futureObj.get();
            // first way
            System.out.println(output.get(0));

            //second way
            List<Integer> res = futureObj.get();
            System.out.println(res.get(0));
        }catch(Exception e){

        }

    }
}
