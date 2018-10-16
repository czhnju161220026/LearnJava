 enum Color{
    WHITE,
    BLACK,
    BLUE,
    GREEN
}

enum Size{
    SMALL,
    MEDIUM,
    LARGE
}

class Shirt{
    public Color color;
    public Size size;
    Shirt(Color color,Size size){
        this.color=color;
        this.size=size;
    }
}
public class EnumTest {
    public static void main(String []args){
        Shirt shirts[]=new Shirt[5];
        shirts[0]=new Shirt(Color.WHITE,Size.SMALL);
        System.out.println(shirts[0].color+" "+shirts[0].size);
        System.out.println((shirts[0].color.ordinal())+" "+shirts[0].size.ordinal());
    }
}
