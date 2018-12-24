package genetic;

import java.util.Arrays;

class Person { }
class Man extends Person { }
class Job<T extends Person> { }
public class GeneticLearn7 {
    public static  void main(String[] args) {
        Job<Man> job = new Job<>();
        System.out.println(Arrays.toString(job.getClass().getTypeParameters()));
    }
}
