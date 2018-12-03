package nju.cui;

public class Sort {
    public static void enumSort(int[] array,int length) {
        int[] b = new int[length];
        for(int i = 0;i < length;i++) {
            int value = array[i];
            int index = 0;
            for(int j = 0;j < length;j++) {
                if(array[j] < value) {
                    index++;
                }
            }
            b[index] = value;
        }
        for(int i = 0;i < length;i++) {
            array[i] = b[i];
        }
    }
}
