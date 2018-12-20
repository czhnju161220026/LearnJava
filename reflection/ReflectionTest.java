package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String [] args) {
        String className;
        Scanner scanner = new Scanner(System.in);
        className = scanner.nextLine();
        try {
            Class<?>c = Class.forName(className);
            Method[] methods = c.getDeclaredMethods();
            Field[] fields = c.getFields();
            for(Method method : methods) {
                System.out.println(method);
            }
            for(Field field : fields) { //只能获得public的域
                System.out.println(field);
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
