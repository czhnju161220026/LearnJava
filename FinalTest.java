
final class AFinalClass {
    final int finalField = 0;
    int x;
    public AFinalClass() {
        x = 0;
    }
    public AFinalClass(int x) {
        this.x = x;
        //Error: can't change the value of a final field
        //finalField =1;
    }
    final void f() {
        System.out.println("A final method");
    }

}

//Error: can't extend a final class
//class subClass extends aFinalClass { }

public class FinalTest {
    void f(final AFinalClass finalClass) {
        //Error: can't assign value to final reference
        //finalClass = new AFinalClass(5);
    }

    public static void main(String[] args) {
        AFinalClass finalClass = new AFinalClass(5);
        finalClass.f();
    }
}
