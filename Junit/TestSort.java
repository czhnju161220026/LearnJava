package nju.cui;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;

public class TestSort {
    @Test(expected = Exception.class)
    public void testSort() throws Exception{
        int[] array = new int[1000];
        for(int i =0;i<1000;i++) {
            array[i] = 1500-3*i;
        }
        Sort.enumSort(array,1000);
        boolean flag = true;
        for(int i = 0;i<999;i++) {
            if(array[i]>array[i+1]) {
                flag = false;
            }
        }
        if(flag) {
            throw new Exception();
        }
    }
    @Test(timeout = 500)
    public void testSort2() throws Exception {
        int[] array = new int[10000];
        for(int i = 0;i<10000;i++) {
            array[i] = 10000-i;
        }
        Sort.enumSort(array,10000);
    }
}
