package genetic;

class TriTuple<A,B,C> {
    public final A a;
    public final B b;
    public final C c;
    public TriTuple(A a,B b,C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString() {
        return ""+a+","+b+","+c;
    }
}
public class GeneticLearn1 {
    public static <A,B,C>  TriTuple<A,B,C> f(A a,B b,C c) {
        return new TriTuple<A, B, C>(a,b,c);
    }

    public static void main(String[] args) {
        System.out.println(f(1,2,"Test"));
        System.out.println(f(1.5,3,'a'));
    }
}
