package genetic;

//通配符

import java.util.ArrayList;
import java.util.Arrays;

public class GeneticLearn6 {
    public static void main(String[] args) {
        //上界通配符：某种确切子类型
        ArrayList<Apple> apples = new ArrayList<>();
        apples.addAll(Arrays.asList(new Apple(),new Apple()));
        ArrayList<? extends Fruit> flist= apples;
        //可以取不可以添加
        //只能取出上界
        //flist.add(new Apple());
        Fruit fruit = flist.get(0);
        System.out.println(fruit);

        //下界通配符：某种确切的父类型
        //可以添加，但是只能取出Object
        ArrayList <? super Apple> appleList = new ArrayList<Fruit>();
        appleList.add(new Apple());
        appleList.add(new Fuji());
        try {
            Apple apple = (Apple) appleList.get(0);
            Fuji fuji = (Fuji)appleList.get(1);
            System.out.println(apple);
            System.out.println(fuji);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }


    }
}
