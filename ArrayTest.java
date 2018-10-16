import  java.util.*;

public class ArrayTest {
    public static void main(String[] args){
        test(10);
    }

    private static void test(int x){
        String[] strs = new String[x];
        Random rand = new Random(10);
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
       //char[] chars=str.toCharArray();
        for(int j=0;j<x;j++){
            String temp="";
            for(int i=0;i<20;i++){
                temp+=str.charAt(rand.nextInt(62));
                //temp+=chars[rand.nextInt(62)];
            }
            strs[j]=temp;
        }

        for(String s:strs){
            System.out.println(s);
        }
    }
}


