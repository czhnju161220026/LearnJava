package concurrent;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyEvenGenerator2 implements EvenGenerator {
    static boolean cancled = false;
    static int currentValue = 0;
    private Lock lock = new ReentrantLock();
    public int next() {
        lock.lock();
        try{
            currentValue++;
            Thread.yield();
            currentValue++;
            return currentValue;
        }
        finally {
            lock.unlock();
        }
    }
    public boolean isCancled() {
        return cancled;
    }

    public void cancle() {
        cancled = true;
    }
}
public class LockTest {
    public static  void main(String[] args) {
        System.out.println("Start");
        ExecutorService exec = Executors.newCachedThreadPool();
        MyEvenGenerator2 myEvenGenerator = new MyEvenGenerator2();
        for(int i = 0;i<10;i++) {
            exec.execute(new Counter(myEvenGenerator));
        }
        exec.shutdown();
    }
}
