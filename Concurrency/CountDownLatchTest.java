package concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WaitingTask implements  Runnable {
    private static final CountDownLatch latch= new CountDownLatch(20);
    private int id;
    public WaitingTask(int id) {
        this.id = id;
    }
    private void doSomeWorking() {
        System.out.println("Task:"+id+" is doing some working.");
        try {
            Random random = new Random();
            TimeUnit.MILLISECONDS.sleep(500+random.nextInt(500));
            latch.countDown();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        doSomeWorking();
        try {
            latch.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task:"+id+" pass.");
    }
}
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0;i < 20;i++) {
            executor.execute(new WaitingTask(i));
        }
        executor.shutdown();
    }
}
