package 注解;

import java.lang.annotation.*;

/**
 * 一个用于测试的注解
 */
@Inherited
@Target(ElementType.METHOD) //作用于方法的注解
@Retention(RetentionPolicy.RUNTIME)
public @interface OP {
    int code();
    String des();
}
