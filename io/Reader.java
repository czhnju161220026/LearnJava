package io;

import java.io.*;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(new File("a.txt")));
        Scanner scanner = new Scanner(read);
        System.out.println(scanner.nextInt());
        System.out.println(scanner.next());
        scanner.close();

    }
}
