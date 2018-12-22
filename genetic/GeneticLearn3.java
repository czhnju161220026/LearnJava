package genetic;

import java.util.Iterator;
import java.util.Random;

//泛型接口与内部类
class  CoffeeGenerator implements Iterable<Coffee> {
    private final int num;
    private int count;
    public CoffeeGenerator(int num) {
        this.num = num;
        this.count = 0;
    }

    public CoffeeGenerator() {
        this.num = 10;
        this.count = 0;
    }

    class CoffeeIterator implements Iterator<Coffee> {

        public boolean hasNext () {
            return count < num;
        }
        public Coffee next() {
            count++;
            Random random = new Random();
            int choice = (random.nextInt(100))%2;
            switch (choice) {
                case 0:
                    return new Mocha();
                case 1:
                    return new Lattee();
                default:
                    return null;
            }
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
}
public class GeneticLearn3 {
    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator(10);
        for(Coffee coffee:coffeeGenerator) {
            System.out.println(coffee);
        }
    }
}
