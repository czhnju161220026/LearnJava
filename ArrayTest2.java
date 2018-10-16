public class ArrayTest2{
    public static void main(String[] args){
        Echo objs[]=new Echo[10];
        System.out.println("Creat");
        for(int i=0;i<10;i++) {
            objs[i]=new Echo("echo"+i);
        }
        System.out.println("Initialize");
    }
}

class Echo {
    Echo(String str){
        System.out.println(str);
    }
}
