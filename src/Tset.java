import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sabrouch.
 * Date: 12/7/2020
 */

public class Tset {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("sssss");
            }
        };
        new Thread(r).start();
    }
    Callable c = new Callable() {
        @Override
        public Object call() throws Exception {
            return 4+5;
        }
    };
    ExecutorService executorService = Executors.newFixedThreadPool(2);
   List<Callable<Integer>> re = Arrays.asList(c);
    Integer r;

    {
        try {
            r = executorService.invokeAny(re);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
