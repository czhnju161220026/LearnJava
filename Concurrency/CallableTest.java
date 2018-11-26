import java.util.ArrayList;
import java.util.concurrent.*;

class CallableTask implements Callable<String> {
    private static int count=0;
    private int id = ++count;
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("线程：");
        stringBuilder.append(id);
        stringBuilder.append("被调用运行");
        return stringBuilder.toString();
    }
}
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for(int i = 0;i<10;i++) {
            futures.add(exec.submit(new CallableTask()));
        }
        for(Future<String> res:futures) {
            try {
                System.out.println(res.get());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
    }
}
