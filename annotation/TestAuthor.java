package annotation;

public class TestAuthor {
    @AuthorAnnotation(name="张顺飞",url="6324")
    public static void main(String[] args) {
        Test();
    }

    @AuthorAnnotation
    static void Test() {
        System.out.println("this is a test method");
    }

    @AuthorAnnotation(name="朱庭纬",url="161220186@smail.nju.edu.cn")
    static void Test2() {
        System.out.println("This is another method");
    }
}
