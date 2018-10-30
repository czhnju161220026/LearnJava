import java.io.*;
import java.util.*;

public class TestList2 {
    public static void main(String[] args) {
         /*Sort an  integer arraylist*/
         Integer[] array = {1,5,8,7,4,6,9};
        ArrayList<Integer> arrayList  =  new ArrayList<>();
        Collections.addAll(arrayList,array);

        for(Integer x : arrayList) {
            System.out.printf("%d,",x);
        }
        System.out.println();

        Collections.sort(arrayList);
        System.out.println(arrayList);

        /*Sort an students list*/
        ArrayList<Student>  arrayList1 = new ArrayList<>();
        Student[] students = {new Student(2, "jack"),new Student(5,"Lucy"),new Student(7,"Tom")};
        Collections.addAll(arrayList1,students);
        Collections.sort(arrayList1);
        System.out.println(arrayList1);

        /*Test priorityQueue*/

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        for(int i = 0;i<20;i++) {
            priorityQueue.add(random.nextInt(100));
        }

        Iterator<Integer> iterator = priorityQueue.iterator();
        while(iterator.hasNext()) { // insert Sequence
            System.out.printf("%d, ",iterator.next());
        }

        System.out.println();
        while(!priorityQueue.isEmpty()) { //Sorted Sequence
            Integer x = priorityQueue.remove();
            System.out.printf("%d, ",x);
        }
    }
}

/*if i want to use Collections.sort, the Class must implements inferface Comparable*/
class Student implements Comparable {
    private  int id;
    private String name;

    public int compareTo(Object obj) {
        try {
            Student s2 = (Student) obj;
            if (id == s2.id) {
                return 0;
            } else if (id < s2.id) {
                return -1;
            } else {
                return 1;
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return 0;
    }
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(id);
        stringBuilder.append(" "+name);
        return stringBuilder.toString();
    }
}


