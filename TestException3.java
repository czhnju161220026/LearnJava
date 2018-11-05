import java.util.ArrayList;

public class TestException3 {
    public static void main(String[] args) {
        try {
            StringReverse stringReverse = new StringReverse();
            System.out.println(stringReverse.reverse("Good news"));
            System.out.println(stringReverse.reverse("this is a bad news"));

        }
        catch (JudegExpection e) {
            e.printStackTrace();
        }

        finally {
            System.err.println("Expection triggered");
            System.exit(-1);
        }
    }
}

class JudegExpection extends Exception {
    @Override
    public String getMessage() {
        return "JudgeExpection triggered "+super.getMessage();
    }

    public JudegExpection(String msg) {
        super(msg);
    }
}

class StringReverse {
    public String reverse(String x) throws JudegExpection {
        if(x.length()>10) {
            throw  new JudegExpection("this String is too long");
        }
        String res = new StringBuffer(x).reverse().toString();
        return res;
    }
}

