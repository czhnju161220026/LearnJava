import java.util.*;

class MyTask implements Runnable {
    static int count=0;
    private final int id=++count;
    private int time=5;
    public void run() {
        while(time>0) {
            System.out.println("线程:"+id+",剩余:"+time);
            time--;
            Thread.yield();
        }
    }
}
public class RunnableTest {
    public static void main(String[] args) {
        MyTask myTask1 = new MyTask();
        myTask1.run();
    }
}
