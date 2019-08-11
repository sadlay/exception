package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.ExceptionEnumHandle;

/**
 * 安全异常（通常为鉴权和认证错误时候抛出）
 *
 * @auther liyanna
 * @Date 2019/7/31 15:18
 */
public class SecurityException extends AbstractException {

    public SecurityException(ExceptionEnumHandle exceptionEnumHandle) {
        super(exceptionEnumHandle);
    }
    public SecurityException(ExceptionEnumHandle exceptionEnumHandle, String extraMessage) {
        super(exceptionEnumHandle, extraMessage);
    }

    public SecurityException(Integer code, String errorMessage) {
        super(code, errorMessage);
    }
}