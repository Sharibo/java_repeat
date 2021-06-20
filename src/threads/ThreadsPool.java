package threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService exec = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            results.add(exec.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " - done.");
                    return Thread.currentThread().getName();
                }

            }));

        }

        // Объявляет, что в пул потоков больше ничего передаваться не будет
        exec.shutdown();

        for (Future<String> result : results) {
            System.out.println("Got result: " + result.get()); // get = join с возвращаемым значением
        }

        System.out.println("End of main()");

    }

}
