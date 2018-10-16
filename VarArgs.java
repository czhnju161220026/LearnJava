
public class VarArgs {
    private static void f(Object ... objs){
        for(Object obj : objs){
            System.out.print(""+obj+' ');
        }
        System.out.print("\n");
    }

    private static void g(String ... strs){
        for(String str:strs){
            System.out.print(str+" ");
        }
        System.out.print("\n");
    }
    public static  void main(String[] args){
        f(1,12.3,5L,"test");
        g("str1","str2","str3");
        String[] strs={"ss","tt","rr"};
        g(strs);
    }
}
