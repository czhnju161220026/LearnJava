@FunctionalInterface
interface Filter {
    String filter(String string);
}

class FilterProvider {
    public Filter provide1() {
        return new Filter() {
            @Override
            public String filter(String string) {
                return string.toLowerCase();
            }
        };
    }

    public Filter provide2() {
        class UpperFilter implements Filter{
            public String filter(String string) {
                return string.toUpperCase();
            }
        }
        return new UpperFilter();
    }


    public Filter provide3() {
        return  (String string)->{
            return "Lamda";
        };
    }

}

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        FilterProvider fp = new FilterProvider();
        Filter filter1 = fp.provide1();
        System.out.println(filter1.filter("AvadaFwad"));
        System.out.println(fp.provide2().filter("AvadaFwad"));
        System.out.println(fp.provide3().filter("abasadw"));
    }
}
