import  java.util.regex.*;
import java.util.Scanner;
public class BasicRegex {
    public static  void main(String[] args ) {
        String src = new String("this is a simpla regex test" +
                "www.baidu.comwww.google.comwww.sina.com");
        Pattern pattern = Pattern.compile("w{3,3}[^w]+");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
