package concurrent;

import java.util.concurrent.TimeUnit;

class Sleeper implements Runnable {
    public void run(){
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Now I'm sleeping,Don't borther me");
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Awaker implements Runnable {
    private Thread thread;
    public Awaker(Thread thread) {
        this.thread = thread;
    }
    public void run() {
        System.out.println("Wake up!");
        try{
            thread.run();
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ok,fine");
    }
}
public class Join {

    public static  void main(String[] args) {
        Thread sleeper = new Thread(new Sleeper());
        Thread awaker = new Thread(new Awaker(sleeper));
        awaker.run();
    }
}
