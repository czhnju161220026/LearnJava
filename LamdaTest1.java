@FunctionalInterface
interface Worker {
    void doSomeWork() ;
}

class WorkerLeader {
    void getWorker(Worker worker) {
        worker.doSomeWork();
    }
}

public class LamdaTest1 {
    public static  void main(String[] args) {
        WorkerLeader workerLeader = new WorkerLeader();
        workerLeader.getWorker(new Worker() {
            @Override
            public void doSomeWork() {
                System.out.println("通过匿名内部类实现");
            }
        });

        workerLeader.getWorker(()->
                System.out.println("通过lamda表达式实现"));
    }
}
