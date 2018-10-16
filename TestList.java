import java.awt.*;
import  java.util.*;

public class TestList {
    public static  void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0;i < 10;i++) {
            arrayList.add(random.nextInt(30));
        }
        System.out.println("Traverse List");

        // 1
        for(int i = 0;i < 10;i++) {
            System.out.print(" "+arrayList.get(i));
        }
        System.out.print("\n");

        //2
        for(Integer x:arrayList) {
            System.out.print(" "+x);
        }
        System.out.print("\n");

        //3
        ListIterator<Integer> listIterator = arrayList.listIterator();
        while(listIterator.hasNext()) {
            System.out.print(" "+listIterator.next());
        }
        System.out.print("\n");


        System.out.println("Test Set");
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        for(int i=0;i<10000;i++) {
            int x = random.nextInt(29);
            treeSet.add(x);
            hashSet.add(x);
            linkedHashSet.add(x);
        }

        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.print(" "+iterator.next());
        }

        System.out.println();

        for(Integer x:hashSet) {
            System.out.print(" "+x);
        }

        System.out.println();
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);

        System.out.println("Test Map");
        TreeMap<Integer,String>treeMap = new TreeMap<>();
        HashMap<Integer,String>hashMap = new HashMap<>();
        LinkedHashMap<Integer,String>linkedHashMap = new LinkedHashMap<>();

        treeMap.put(1,"崔子寒");
        treeMap.put(2,"顾宇峰");
        treeMap.put(3,"孙笑川");
        treeMap.put(4,"李老八");

        hashMap.putAll(treeMap);
        linkedHashMap.putAll(treeMap);

        System.out.print(""+treeMap+"\n"+hashMap+"\n"+linkedHashMap+"\n");

        System.out.println(treeMap.get(3));

    }
}
