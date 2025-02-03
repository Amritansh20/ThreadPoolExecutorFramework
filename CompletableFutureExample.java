import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> completableFuture1 =  CompletableFuture.supplyAsync(()->{
        try{
            System.out.println("Thread name of supply async: " + Thread.currentThread().getName());
           Thread.sleep(5000);
        }catch(Exception e){

        }
        return "CONCEPT ";
        },executor);

        CompletableFuture<String> completableFuture2= completableFuture1.thenApply((String val)->{
            System.out.println("Thread name of thenApply: " + Thread.currentThread().getName());
            return val + "AND ";
        });

        CompletableFuture<String> completableFuture3= completableFuture2.thenApply((String val)->{
            System.out.println("Thread name of thenApply: " + Thread.currentThread().getName());
            return val + "CODING.";
        });


    }
}
