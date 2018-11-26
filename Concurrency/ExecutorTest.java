import java.util.concurrent.*;
class MyTask implements Runnable {
    static int count=0;
    private final int id=++count;
    private int time=5;
    public void run() {
        while(time>0) {
            System.out.println("线程:"+id+",剩余:"+time);
            time--;
            //Thread.yield();
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                ;
            }
        }
    }
}
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            executorService.execute(new MyTask());
        }
        executorService.shutdown();
    }
}
