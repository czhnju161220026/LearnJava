import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DIsplayStringMethods {
    public  static  void main(String[] args) {
        String string = new String("Java is a object-oriented language. I think Java is the best language.");
        System.out.println(string.length());
        for(int i = 0;i<string.length();i++) {
            System.out.print(string.charAt(i));
        }
        System.out.println();
        char[] chars = new char[10];
        string.getChars(0,10,chars,0);  //[srcBegin,srcEnd)
        System.out.println(chars);

        char[] sameString = string.toCharArray();
        System.out.println(sameString);

        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());

        System.out.println(string.contains("Java"));
        System.out.println(string.regionMatches(0,"Java",0,4));

        System.out.println(string.startsWith("java"));
        System.out.println(string.endsWith("language."));

        System.out.println(string.indexOf('J'));
        System.out.println(string.lastIndexOf('J'));

        System.out.println(string.substring(10,25));

        System.out.println(string.concat("But someone thinks php is the best language."));
        System.out.println(string.replace('o','O'));

    }
}


