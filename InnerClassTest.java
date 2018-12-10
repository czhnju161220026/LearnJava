import java.util.ArrayList;

interface Selector{
    boolean hasNext();
    int next();
    void set(int val);
}

class Outer{
    private int[] list;
    Outer(int length) {
        list = new int[length];
    }
    public Selector getSelector(){
        return new Selector(){
            int i = 0;
            public boolean hasNext() {
                return i < list.length-1;
            }
            public int next() {
                return list[i++];
            }

            public void set(int val) {
                list[i] = val;
            }
        };
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer(10);
        Selector s = outer.getSelector();
        while(s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
