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
public class ThreadTest {
    public static void main(String[] args) {
        for(int i = 0;i<5;i++) {
            Thread thread = new Thread(new MyTask());
            thread.start();
        }
        //可以看到各个线程交错并发执行
    }
}
