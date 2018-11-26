import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskWithPriority implements Runnable {
    private int priority;
    private static int count=0;
    private int id = ++count;
    private volatile double d;
    private  int countDown=5;
    public TaskWithPriority(int priority) {
        this.priority = priority;
    }
    public void run() {
        //获得当前进程的引用
        Thread.currentThread().setPriority(priority);
        //长时间占用时间片的操作
        while(true) {
            for(int i =0;i<100000;i++) {
                d+=(Math.PI+Math.E)/(double)i;
                if(i%1000==0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown==0) {
                return;
            }
        }

    }
    public String toString() {
        return ""+Thread.currentThread() + ":"+countDown;
    }
}
public class PriorityTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++) {
            executorService.execute(new TaskWithPriority(Thread.MIN_PRIORITY));
        }
        executorService.execute(new TaskWithPriority(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
