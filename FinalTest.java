import java.util.*;

class FinalData {
    static private Random rand = new Random(33);
    private final String name;
    final int id = rand.nextInt();

    public FinalData(String name) {
        this.name = name;
    }

    public String toString() {
        return "ID: "+id+"\nName: "+name;
    }
}

public class FinalTest {
    public static void main(String[] args){
        FinalData f1=new FinalData("lilaoba");
        FinalData f2=new FinalData("sunxiaochuan");
        System.out.println(f1);
        System.out.println(f2);
    }
}
