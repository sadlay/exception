package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.EnumHandle;

/**
 * 请求异常（通常为请求参数验证错误等时候抛出）
 *
 * @auther liyanna
 * @Date 2019/7/31 15:18
 */
public class RequestException extends AbstractException {

    public RequestException(EnumHandle enumHandle) {
        super(enumHandle);
    }

    public RequestException(EnumHandle enumHandle, String extraMessage) {
        super(enumHandle, extraMessage);
    }

    public RequestException(Integer code, String errorMessage) {
        super(code, errorMessage);
    }
}