package annotation;
import java.lang.reflect.*;

public class AuthorTracker {
    public static void trackAuthors(Class<?> cl) {
        for(Method m:cl.getDeclaredMethods()) {
            AuthorAnnotation author = m.getAnnotation(AuthorAnnotation.class);
            if(author!=null) {
                System.out.println("Found author:"+author.name()+" at "+author.url()+", contributing to "+m);
            }
        }
    }

    public static  void main(String[] args) {
        trackAuthors(TestAuthor.class);
        /* output:
        * Found author:张顺飞 at 6324, contributing to public static void annotation.TestAuthor.main(java.lang.String[])
        Found author:崔子寒 at dev.tencent.com/997520420, contributing to static void annotation.TestAuthor.Test()
        Found author:朱庭纬 at 161220186@smail.nju.edu.cn, contributing to static void annotation.TestAuthor.Test2()
        */
    }
}
