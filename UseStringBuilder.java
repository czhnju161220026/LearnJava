public class UseStringBuilder {
    public static  void main(String[] args) {
        String src = new String("This is a test ");
        StringBuilder stringBuilder = new StringBuilder(src);
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse().toString());
        System.out.println(stringBuilder.append(" ,add some new src").toString());
        //String is unchanggable, but stringbuilder can be changed
    }
}
