import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Frank_Hon on 2022/7/27 1:23 PM.
 * E-mail: frank_hon@foxmail.com
 *
 * {} braces
 * [] square brackets
 * () round brackets/ parentheses
 * <> angle brackets
 */
public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            threadPool.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            threadPool.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        Thread.sleep(2000);
        threadPool.shutdown();
//        List<Number> a= new ArrayList<>();
        System.out.println(~~2);
    }
}
