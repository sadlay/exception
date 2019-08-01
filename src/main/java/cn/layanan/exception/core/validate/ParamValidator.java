package cn.layanan.exception.core.validate;

import java.lang.annotation.*;

/**
 * 参数验证注解（控制器加上后会对实现Validator的参数实体进行参数校验）
 *
 * @Author liyanan
 * @Date 2019/7/31 16:05
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamValidator {
}
