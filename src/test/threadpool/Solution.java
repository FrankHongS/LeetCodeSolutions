package test.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(0);

//        while (true){
//            scheduledExecutorService.schedule(()->{
//                System.out.println(Thread.currentThread().getName()+" "+System.currentTimeMillis());
//                try {
//                    Thread.sleep(2500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            },1000, TimeUnit.MILLISECONDS);
//        }

        scheduledExecutorService.scheduleAtFixedRate(
                ()->{
                    System.out.println("First: "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
//                    try {
//                        Thread.sleep(2500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                },
                500L,
                50,
                TimeUnit.MILLISECONDS
        );

//        scheduledExecutorService.scheduleAtFixedRate(
//                ()->{
//                    System.out.println("Second: "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
//                    try {
//                        Thread.sleep(2500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                },
//                500L,
//                1000,
//                TimeUnit.MILLISECONDS
//        );

    }

}
