package cn.layanan.exception.example.core.validate;

import cn.layanan.exception.example.core.enums.ErrorCodeEnum;
import cn.layanan.exception.example.core.exception.RequestException;
import cn.layanan.exception.example.core.util.EmptyUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 参数校验aop（如果校验失败则抛出异常）
 *
 * @Author liyanan
 * @Date 2019/7/31 16:08
 */
@Aspect
@Order(888)
public class ParamValidatorAop {
    public ParamValidatorAop() {
    }

    @Pointcut("@annotation(cn.layanan.exception.example.core.validate.ParamValidator)")
    private void cutService() {
    }

    @Around("cutService()")
    public Object doInvoke(ProceedingJoinPoint point) throws Throwable {
        Object[] methodParams = point.getArgs();
        if (methodParams != null && methodParams.length > 0) {
            validateParameters(methodParams);
            return point.proceed();
        } else {
            return point.proceed();
        }
    }

    private void validateParameters(Object[] methodParams) {
        Object[] var1 = methodParams;
        int var2 = methodParams.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Object methodParam = var1[var3];
            if (methodParam instanceof Validator) {
                Validator validator = (Validator) methodParam;
                String result = validator.validate();
                if (EmptyUtil.isNotEmpty(result)) {
                    throw new RequestException(ErrorCodeEnum.PARAM_ERROR, result);
                }
            }
        }

    }
}
