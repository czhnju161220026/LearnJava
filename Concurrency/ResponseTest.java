import java.io.IOException;

class UnresponsiveUI {
    private volatile  double d=1;
    public UnresponsiveUI() throws  Exception {
        while(d>0) {
            d=d+Math.PI-Math.E;
        }
        System.in.read();
    }
}

class ResponsiveUI implements Runnable {
    private volatile  double d=1;
    public void run() {
        while(d>0) {
            d=d+Math.PI-Math.E;
        }
    }
}

public class ResponseTest {
    public static void main(String[] args) throws Exception {
        System.out.println("按任意键继续");
        //不使用并发的话，会阻塞
        //UnresponsiveUI unresponsiveUI = new UnresponsiveUI();
        Thread thread = new Thread((new ResponsiveUI()));
        thread.setDaemon(true);
        thread.start();
        System.in.read();
        System.out.println("End");
    }
}
