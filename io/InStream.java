package io;

import java.io.*;

public class InStream {
    public static void main(String[] args) {
        try {
            DataInputStream fin = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("test"))));
            int a = fin.readInt();
            char b = fin.readChar();
            double c = fin.readDouble();
            System.out.println(""+a+" "+b+" "+c);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
