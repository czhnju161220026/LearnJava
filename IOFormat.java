import java.util.Formatter;
import java.io.*;

public class IOFormat {
    public static  void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        formatter.format("%s have %d courses, the best goal is %f\n","I",5,99.5);

        formatter = new Formatter(System.err);
        formatter.format("%s have %d courses, the best goal is %f\n","I",5,99.5);

        System.out.printf("%-15s%10s%10s\n","CourseName","Credits","Scores");
        System.out.printf("%-15s%10s%10s\n","----------","-------","-----");
        System.out.printf("%-15s%10d%10.2f\n","Algorithm",4,96.5);
        System.out.printf("%-15s%10d%10.2f\n","Ahwod",51,98.546);
        // without '-' ,it is central aligement

        String string = String.format("This is a %s test","String.format");
        System.out.println(string);


    }
}
