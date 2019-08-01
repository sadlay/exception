package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.EnumHandle;

/**
 * 安全异常（通常为鉴权和认证错误时候抛出）
 *
 * @auther liyanna
 * @Date 2019/7/31 15:18
 */
public class SecurityException extends AbstractException {

    public SecurityException(EnumHandle enumHandle) {
        super(enumHandle);
    }
    public SecurityException(EnumHandle enumHandle, String extraMessage) {
        super(enumHandle, extraMessage);
    }

    public SecurityException(Integer code, String errorMessage) {
        super(code, errorMessage);
    }
}