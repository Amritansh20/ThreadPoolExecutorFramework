import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable{
    List<Integer> list;

    MyRunnable(List<Integer> list){
        this.list= list;
    }
    @Override
    public void run() {
        list.add(300);
    }
}
