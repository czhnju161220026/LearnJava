import java.util.*;

class MyException extends Exception {
    private int category;
    public MyException(){};
    public MyException(String msg) {
        super(msg);
    }
    public MyException(String msg, int category) {
        super(msg);
        this.category = category;
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

class TestMyException {
    public void f(int category) throws MyException{
        if(category<1||category>4) {
            throw new MyException("Expect value 1-4, obtain "+category);
        }
        else {
            System.out.println("OK");
        }
    }
}

public class TestException{
    public static void main(String[] args) {
        try{
            TestMyException testMyException = new TestMyException();
            testMyException.f(1);
            testMyException.f(2);
            testMyException.f(5);
        }
        catch (MyException e) {
            e.printStackTrace();
            System.err.println("Expection triggered");
            System.exit(-1);
        }
    }
}


