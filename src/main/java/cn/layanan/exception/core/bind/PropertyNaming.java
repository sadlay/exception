package cn.layanan.exception.core.bind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性命名
 *
 * @Author: lay
 * @Date: Created in 13:37 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyNaming {
}
