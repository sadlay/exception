package cn.layanan.exception.core.validate;

import org.springframework.core.annotation.AliasFor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:52 2019/8/5
 * @Modified By:IntelliJ IDEA
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEqualValidator.class)
public @interface NotEqual {

    @AliasFor("notEqualValues")
    String[] value() default {};

    @AliasFor("value")
    String[] notEqualValues() default {};

    String message() default "不能与特定的值相等";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
