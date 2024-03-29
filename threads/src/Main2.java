import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService pool=
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        ConcurrentLinkedDeque<String> data=new ConcurrentLinkedDeque<>();

        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();

        Future<String> a= pool.submit(()->{
            data.add("hany");
            return "";
        });
        Future<String> b= pool.submit(() -> {
            data.add("nemr");
            return "";
        });

        try {
            a.get();
            b.get();
            System.out.println("end");
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //lock
//        ReentrantLock locker=new ReentrantLock();
//
//        ArrayList<String> data=new ArrayList<>();
//        pool.submit(()->{
//            locker.lock();
//            data.add("hany");
//            locker.unlock();
//        });
//        pool.submit(() -> {
//            locker.lock();
//            data.add("nemr");
//            locker.unlock();
//        });


        System.out.println(data);


        //invoke any
//        List<Callable<String>> tasks=List.of(() -> {
//            TimeUnit.SECONDS.sleep(4);
//            return "hany";
//        },() -> {
//            TimeUnit.SECONDS.sleep(7);
//            return "nemr";
//        });
//
//        try {
//            String result = pool.invokeAny(tasks);
//            System.out.println(result);
//        } catch (InterruptedException | ExecutionException e) {
//
//        }


        //invoke all
//        List<Callable<String>> tasks=List.of(() -> "hany",() -> "nemr");
//        try {
//            List<Future<String>> futures = pool.invokeAll(tasks);
//            String name=futures.get(0).get();
//            String lastname=futures.get(1).get();
//            System.out.println(name+lastname);
//        } catch (InterruptedException | ExecutionException e) {
//
//        }

        //submit
//        Future<String> name = pool.submit(() -> "hany");
//        Future<String> lastName = pool.submit(() -> "nemr");
//        try {
//            String fullname=name.get()+lastName.get();
//            System.out.println(fullname);
//        } catch (InterruptedException | ExecutionException e) {
//            System.out.println("error");
//        }

        try {
            pool.shutdown();
            pool.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
