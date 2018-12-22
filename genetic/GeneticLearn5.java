package genetic;

import java.awt.*;

class Fruit {
    int vc;
    int calories;
    public Fruit(int vc, int calories) {
        this.vc = vc;
        this.calories = calories;
    }

    public Fruit() {
        this.vc = 100;
        this.calories = 200;
    }

    @Override
    public String toString() {
        return "vc: "+vc+", calories: "+calories;
    }

    public void introduce() {
        System.out.println("Fruit is good");
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple,"+super.toString();
    }
}

class Fuji extends Apple {
    @Override
    public String toString() {
        return "Fuji,"+super.toString();
    }
}

class Pear extends Fruit {
    @Override
    public String toString() {
        return "Pear,"+super.toString();
    }
}

interface FruitFactory<T> {
    T create() ;
}
class AppleFactory implements FruitFactory<Apple> {
    public Apple create() {
        return new Apple();
    }
}

class PearFactory implements FruitFactory<Pear> {
    public Pear create() {
        return new Pear();
    }
}

class Plate<T extends Fruit> {
    private T food;
    private Class<? extends T> foodClass;
    public Plate() {

    }
    //想在泛型容器来建立对象，只能传入Class对象或者使用工厂方法中的生成器
    public Plate(Class<? extends T> foodClass) {
        //food = new T();
        this.foodClass = foodClass;
        try{
            food = foodClass.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //工厂方法
    public <F extends FruitFactory<? extends T>> Plate(F factory) {
        food = factory.create();
    }
    public void addFood(T food) {
        this.food = food;
    }

    public void show() {
        System.out.println(food);
        food.introduce(); //因为限制了上界，会被擦除到fruit，可以使用fruit的方法
    }
}
public class GeneticLearn5 {
    public static void main(String[] args) {
        Plate<Fruit> plate = new Plate<>();
        plate.addFood(new Pear());
        plate.show();

        plate = new Plate<Fruit>(Apple.class); //newInstance不能保证T具有默认构造器，可能会出问题，工厂方法最好
        plate.show();

        plate = new Plate<>(new AppleFactory());
        plate.show();

        plate = new Plate<>(new PearFactory());
        plate.show();
    }
}
