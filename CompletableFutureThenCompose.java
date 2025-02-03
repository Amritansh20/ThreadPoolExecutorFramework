import java.util.concurrent.*;

public class CompletableFutureThenCompose {
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

        CompletableFuture<String> completableFuture2= completableFuture1.thenComposeAsync((String val)->{
            System.out.println("Thread name of supply async: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(()->{
                return val + " AND ";
            });
        },executor);

    }
}
