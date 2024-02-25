import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Integer> data=new ArrayList<>();
        Collections.addAll(data,20,12,23,14,25,30,11,45,20);

        OptionalInt max1 = data.parallelStream().mapToInt(e -> e).max();

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

//        pool.invokeAny()
        pool.submit(()->{
            Future<Integer> a= pool.submit(() -> {
                int max = Collections.max(data.subList(0,data.size()/2));
                return max;
            });


            Future<Integer> b= pool.submit(() -> {
                int max = Collections.max(data.subList(data.size()/2,data.size()));
                return max;
            });


            try {
                System.out.println(Integer.max(a.get(),b.get()));
            } catch (InterruptedException e) {

            } catch (ExecutionException e) {

            }
        });

        System.out.println("main app");

        pool.shutdown();
        while (!pool.isTerminated()){}

        try {
            pool.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
