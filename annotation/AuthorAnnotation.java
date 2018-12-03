package annotation;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //如果不是Runtime，那么注解处理器无法在运行时获得这些信息
public @interface AuthorAnnotation {
    String name() default "崔子寒";
    String url() default "dev.tencent.com/997520420";
}