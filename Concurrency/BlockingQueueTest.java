package concurrent;

import java.util.Random;
import java.util.concurrent.*;

class Producer2 implements Runnable {
    private static BlockingQueue<Integer> queue;
    public static void setQueue(BlockingQueue<Integer> queue) {
        Producer2.queue = queue;
    }
    public void run() {
        Random random = new Random();
        while(true) {
            int temp = random.nextInt(100);
            System.out.println("Produce: "+temp);
            queue.offer(temp);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer2 implements Runnable {
    private static BlockingQueue<Integer> queue;
    public static void setQueue(BlockingQueue<Integer> queue) {
        Consumer2.queue = queue;
    }
    public void run() {
        while(true) {
            try {
                int temp = queue.take(); //必须使用take方法取用元素才可以当队列为空时挂起
                if((Integer)temp!=null)
                    System.out.println("Consume: "+temp);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class BlockingQueueTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Producer2.setQueue(queue);
        Consumer2.setQueue(queue);
        executor.execute(new Producer2());
        executor.execute(new Consumer2());
        executor.shutdown();
    }
}
