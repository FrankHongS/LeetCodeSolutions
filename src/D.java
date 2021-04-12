import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Frank_Hon on 2020/12/13 9:16 下午.
 * E-mail: frank_hon@foxmail.com
 *
 * 题目：t1、t2、t3三个线程，如何让三个线程按照顺序依次打印 1-100
 */
public class D {

    public static void main(String[] args) throws InterruptedException {
        D solution = new D();
        solution.printByOrderInThreeThreads(50);
    }

    private void printByOrderInThreeThreads(int value) throws InterruptedException {
        Object lockA = new Object();
        AtomicInteger num = new AtomicInteger(1);
        while (true) {
            new Thread(
                    () -> {
                        synchronized (lockA) {
                            System.out.println(num + ",");
                            lockA.notify();
                        }
                    }
            ).start();
            synchronized (lockA) {
                System.out.println("waiting 1...");
                lockA.wait();
            }
            System.out.println("main 1...");
            if (num.get() >= value) {
                return;
            } else {
                num.incrementAndGet();
            }
            new Thread(
                    () -> {
                        synchronized (lockA) {
                            System.out.println(num + ",");
                            lockA.notify();
                        }
                    }
            ).start();
            synchronized (lockA) {
                System.out.println("waiting 2...");
                lockA.wait();
            }
            System.out.println("main 2...");
            if (num.get() >= value) {
                return;
            } else {
                num.incrementAndGet();
            }
            new Thread(
                    () -> {
                        synchronized (lockA) {
                            System.out.println(num + ",");
                            lockA.notify();
                        }
                    }
            ).start();
            synchronized (lockA) {
                System.out.println("waiting 3...");
                lockA.wait();
            }
            System.out.println("main 3...");
            if (num.get() >= value) {
                return;
            } else {
                num.incrementAndGet();
            }
        }
    }

}
