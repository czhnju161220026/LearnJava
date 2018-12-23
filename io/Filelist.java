package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Filelist {
    public static void main(String[] args) {
        File path = new File("D:\\JavaProject\\JavaLearning\\src\\concurrent");
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(".+(.java)");
            @Override
            public boolean accept(File dir, String name) {
                if(pattern.matcher(name).matches()) {
                    return true;
                }
                return false;
            }
        });

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String str : list) {
            System.out.println(str);
        }
    }
}
