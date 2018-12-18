@FunctionalInterface
interface CalculateFib {
    int fib(int n);
}


public class LamdaTest2 {
    static void calculate(CalculateFib calculateFib,int n) {
        System.out.println("斐波那契数列第"+n+"项:"+calculateFib.fib(n));
    }

    public static void main(String[] args) {
        calculate(new CalculateFib() {
            @Override
            public int fib(int n) {
                if(n == 0 || n == 1) {
                    return 1;
                }
                else {
                    return fib(n-1) + fib(n-2);
                }
            }
        },10);

        calculate((int n)->{
            int a = 1,b = 1;
            for(int i = 0;i < n;i++) {
                int temp = a;
                a = b;
                b += temp;
            }
            return a;
        },10);
    }
}
