package concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

class Racer implements Runnable {
    private static CyclicBarrier cyclicBarrier;
    public static void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        Racer.cyclicBarrier = cyclicBarrier;
    }

    private boolean done = false;
    public boolean isDone() {
        return done;
    }
    private int id;
    private int begin = 0;
    public Racer(int id) {
        this.id = id;
    }
    public void outputInfo() {
        System.out.println("Racer:"+id+", "+begin+"m currently. ");
    }
    public void run() {
        begin = 0;
        Random random = new Random();
        while(!done) {
            begin+=random.nextInt(20);
            try {
                cyclicBarrier.await();
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(begin > 100) {
                done = true;
            }
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
        Racer[] racers = new Racer[10];
        for(int i = 0;i < 10;i++) {
            racers[i] = new Racer(i+1);
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                int num = 10;
                for(int i = 0; i < 10;i++) {
                    if(racers[i].isDone()) {
                        num --;
                        System.out.println("Racer:"+(i+1)+" is done. ");
                    }
                    else {
                        racers[i].outputInfo();
                    }
                }
            }
        });

        Racer.setCyclicBarrier(cyclicBarrier);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i < 10;i++) {
            executorService.execute(racers[i]);
        }
        executorService.shutdown();
    }
}
