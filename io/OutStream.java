package io;

import java.io.*;

public class OutStream {
    public static void main(String[] args) {

        try {
            DataOutputStream fout= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test"))));
            fout.writeInt(123);
            fout.writeChar('a');
            fout.writeDouble(3.14159);
            fout.flush();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
