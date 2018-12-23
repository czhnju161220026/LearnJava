class Father {
    public Father() {
        System.out.println("Father");
    }
}

class Son extends Father {
    public Son() {
        System.out.println("Son");
    }
}

class GrandSon extends  Son {
    public GrandSon() {
        System.out.println("GrandSon");
    }
}

public class InitializeTest {
    public static void main(String[] args) {
        GrandSon grandSon = new GrandSon();
    }
    /*
    * output:
    * Father
        Son
        GrandSon*/
}
