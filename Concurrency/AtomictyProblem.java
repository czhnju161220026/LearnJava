package concurrent;

//解决方法，建立临界区
//通过建立临界区，确保getValue和evenIncrement对value的访问不会冲突
//比起对整个方法加上同步，效率高
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class AtomictyTask implements Runnable{
    private static  int value = 0;
    private boolean cancled= false;
    public boolean isCancled() {
        return cancled;
    }
    public void cancle() {
        cancled = true;
    }

    public void evenIncrement() {
        synchronized (this) {
            value++;value++;
        }
    }
    public  int getValue() {
        synchronized (this) {
            return value;
        }
    }
    public void run() {
        while(!cancled) {
            evenIncrement();
            try{
            TimeUnit.MILLISECONDS.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class AtomictyProblem {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomictyTask at = new AtomictyTask();
        executorService.execute(at);
        executorService.shutdown();
        int value = 0;
        while(true) {
            value = at.getValue();
            if(value%2!=0) {
                break;
            }
            if(value%10==0) {
                System.out.println("Pass:"+value);
            }
        }
        System.out.println("Fault: "+value);
    }

}
