package concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Productor implements Runnable {
    private static int count = 0;
    private int id;
    private static Queue<Integer> queue;
    public static void setQueue(Queue<Integer> queue) {
        Productor.queue = queue;
    }
    public Productor() {
        id = ++count;
    }
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (queue) {
                int newElement = random.nextInt(100);
                queue.offer(newElement);
                System.out.println("Producotr"+id+" produce :"+newElement);
                if(queue.size()==1) {
                    queue.notifyAll();
                }
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

class Consumer implements Runnable {
    private static Queue<Integer> queue;
    private static int count = 0;
    private int id;
    public static void setQueue(Queue<Integer> queue) {
        Consumer.queue = queue;
    }
    public Consumer() {
        id = ++count;
    }
    public void run() {
        while(true) {
            synchronized (queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = queue.poll();
                System.out.println("Consumer"+id+" consume:"+temp);
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

public class WaitAndNotify {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Productor.setQueue(queue);
        Consumer.setQueue(queue);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++) {
            executorService.execute(new Productor());
            executorService.execute(new Consumer());
        }
        executorService.shutdown();
    }
}
