enum CalabashBrother{
    Red(1,"老大","红色"),
    Orange(2,"老二","橙色"),
    Yellow(3,"老三","黄色");
    private int value;
    private String name;
    private String color;
    CalabashBrother(int value,String name,String color){
        this.value=value;
        this.color=color;
        this.name=name;
    }

    int getValue(){
        return value;
    }

    String getName(){
        return name;
    }

    String getColor(){
        return color;
    }
}
public class EnumTest2 {
    public static  void main(String[] args){
        CalabashBrother brothers[]={CalabashBrother.Red,CalabashBrother.Orange,CalabashBrother.Yellow};
        for(CalabashBrother x : brothers) {
            System.out.println(""+x.getValue()+" "+x.getName()+" "+x.getColor());
        }
    }
}
