import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        Future<List<Integer>> futureObj = executor.submit(()->{
            List<Integer> list = new ArrayList<>();
            list.add(300);
            return list;
         });


        try{
            List<Integer> res = futureObj.get();
            System.out.println(res.get(0));
        }catch (Exception e){

        }

    }
}
