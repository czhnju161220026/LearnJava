package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface EvenGenerator {
    public int next();
    public void cancle();
    public boolean isCancled();
}

class MyEvenGenerator implements EvenGenerator {
    private static int currentValue;
    private static boolean cancled = false;
    public int next() {
        currentValue++;
        currentValue++; //因为对currentValue的修改未进行同步，所以会出现错误
        return currentValue;
    }
    public void cancle() {
        cancled = true;
    }
    public boolean isCancled() {
        return cancled;
    }
}

class Counter implements Runnable {
    private EvenGenerator evenGenerator;
    public Counter(EvenGenerator eg) {
        evenGenerator = eg;
    }
    public void run() {
        while(!evenGenerator.isCancled()) {
            int value = evenGenerator.next();
            if(value%2!=0) {
                System.out.println("Wrong! "+value+" is not even");
                evenGenerator.cancle();
            }
        }
    }
}

public class Confilct {
    public static  void main(String[] args) {
        System.out.println("Start");
        ExecutorService exec = Executors.newCachedThreadPool();
        MyEvenGenerator myEvenGenerator = new MyEvenGenerator();
        for(int i = 0;i<10;i++) {
            exec.execute(new Counter(myEvenGenerator));
        }
        exec.shutdown();
    }
}
