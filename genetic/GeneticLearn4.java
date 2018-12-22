package genetic;
//泛型方法
class GeneticMethods {
    public static <T> void f(T arg) {
        System.out.println(arg);
    }
}
public class GeneticLearn4 {
    public static void main(String[] args) {
        GeneticMethods.f(1);
        GeneticMethods.f("hahaha");
    }
}
