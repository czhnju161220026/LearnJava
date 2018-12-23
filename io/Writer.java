package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) throws IOException {
        BufferedWriter fout = new BufferedWriter(new FileWriter(new File("a.txt")));

        fout.write(""+123);
        fout.newLine();
        fout.write("你好Java");
        fout.flush();
        fout.close();
    }
}
