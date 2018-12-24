package io;

import java.io.*;

public class Chaining {
    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        //out的输出变成了in的输入
        //向out中输出一些东西
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] source = {1,2,3,4};
        output.write(source);
        output.writeTo(out);
        byte[] res = new byte[4];
        in.read(res);
        System.out.println(res[0]+" "+res[1]+" "+res[2]+" "+res[3]);

    }
}
