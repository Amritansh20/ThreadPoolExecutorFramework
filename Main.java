import java.util.concurrent.*;

public class Main {

    public static void main(String args[]){
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandeler());

        for(int i=0;i<7;i++){
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(5);
                }catch (Exception e){

                }
                System.out.println("Task processed by: "+Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);

        return th;
    }
}

class CustomRejectHandeler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: "+ r.toString());
    }
}
