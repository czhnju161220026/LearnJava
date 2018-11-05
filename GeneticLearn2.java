abstract class Coffee {
    abstract public String toString();
}
class Lattee extends Coffee {
    public String toString() {
        return "Lattee";
    }
}

class Mocha extends  Coffee {
    public String toString() {
        return "Mocha";
    }
}

class Cup<T extends Coffee> {
    private T coffee;
    public Cup(T coffee) {
        this.coffee = coffee;
    }
    public String toString() {
        return "This is a cup of "+coffee;
    }
}
public class GeneticLearn2 {
    public static  void main(String []args) {
        Cup<Mocha> cup =new Cup<>(new Mocha());
        Cup<Lattee> cup2 = new Cup<>(new Lattee());
       //Cup<Integer>cup3 = new Cup<>(1); compile error
        System.out.println(cup);
        System.out.println(cup2);

    }
}
