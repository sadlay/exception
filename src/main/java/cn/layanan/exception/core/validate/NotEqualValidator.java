package cn.layanan.exception.core.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:56 2019/8/5
 * @Modified By:IntelliJ IDEA
 */

public class NotEqualValidator implements ConstraintValidator<NotEqual, String> {

    private String[] value;

    @Override
    public void initialize(NotEqual constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag = true;
        for (String s1 : value) {
            if (s.equals(s1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
