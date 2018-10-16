import java.util.*;

public class TestException2 {
    public  static  void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i < 10;i++) {
            stack.push(i);
        }

        try {
            for(int i = 0;i<11;i++) {
                System.out.println(stack.pop());
            }
        }
        catch (EmptyStackException e) {
            e.printStackTrace();
        }
        finally {
            System.err.println("Stack Exception Triggered");
            System.exit(-1);
        }

        System.out.println("I'm running");
    }
}




