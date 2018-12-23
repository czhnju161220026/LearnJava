package exception;

class MyNullPointerException extends Exception{ }
class Display {
    public static void display(Object obj) throws MyNullPointerException {
        if(obj == null) {
            throw new MyNullPointerException();
        }
        System.out.println(obj);
    }
}

class Caller {
    public static void call() {
        try {
            Display.display(1);
            Display.display(new Caller());
            Display.display(new Chain());
            Display.display(null);
        }
        catch (MyNullPointerException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
}
public class Chain {
    public static void main(String[] args) {
        Caller.call();
    }
}
