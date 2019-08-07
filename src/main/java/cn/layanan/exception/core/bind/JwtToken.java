package cn.layanan.exception.core.bind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 10:47 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtToken {
    String value() default "uid";
}
