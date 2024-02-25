import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
        //thread pool
        ExecutorService pool=
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        pool.submit(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("loop1 " + i);
        });


        for (int i = 0; i < 100; i++) {
            System.out.println("loop2 "+i);
        }

        try {
            pool.shutdown();
            pool.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {

        }
    }
}
