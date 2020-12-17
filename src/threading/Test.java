package threading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by sabrouch.
 * Date: 12/16/2020
 */

public class Test {
    public static int [] array= IntStream.rangeClosed(0,10).toArray();
    public static int total= IntStream.rangeClosed(0,10).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable call1 = new Callable() {
            @Override
            public Object call() throws Exception {
                int sum =0;
                for (int i=0;i<array.length/2;i++){
                    sum = sum+array[i];
                }
                return sum;
            }
        };
        Callable call2 = ()->{
            int sum =0;
            for (int i=array.length/2;i<array.length;i++){
                sum = sum+array[i];
            }
            return sum;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> list = Arrays.asList(call1,call2);
        List<Future<Integer>> results = executorService.invokeAll(list);
        int k=0;
        int sum=0;
        for(Future<Integer> result:results){
            sum +=result.get();
            System.out.println(k++ +" "+ result.get());
        }
        System.out.println(sum);
        System.out.println(total);
        executorService.shutdown();

    }
}
