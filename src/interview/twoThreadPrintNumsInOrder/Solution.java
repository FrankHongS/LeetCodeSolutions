package interview.twoThreadPrintNumsInOrder;

/**
 * Created by Frank_Hon on 2022/7/22 12:09 AM.
 * E-mail: frank_hon@foxmail.com
 *
 * 两个线程交替打印1～100
 * 快手
 */
public class Solution {

    private final Object lock = new Object();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printNums();
    }

    private void printNums() {
        new Thread(new PrintNumsRunnable(1)).start();
        new Thread(new PrintNumsRunnable(0)).start();
    }

    private class PrintNumsRunnable implements Runnable {

        private final int mod;

        PrintNumsRunnable(int mod) {
            this.mod = mod;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == mod) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        try {
                            Thread.sleep(500);
                            lock.wait();//释放锁资源，被唤醒时，重新去争抢这个锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        lock.notify();//唤醒等待线程，不释放锁资源
                    }
                }
            }
        }
    }

}
