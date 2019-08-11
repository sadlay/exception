package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.ExceptionEnumHandle;

/**
 * 服务异常（通常为业务处理时无法进行时手动抛出）
 *
 * @Author liyanan
 * @Date 2019/7/31 15:00
 */
public class ServiceException extends AbstractException {

    public ServiceException(ExceptionEnumHandle exceptionEnumHandle) {
        super(exceptionEnumHandle);
    }

    public ServiceException(ExceptionEnumHandle exceptionEnumHandle, String extraMessage) {
        super(exceptionEnumHandle, extraMessage);
    }

    public ServiceException(Integer code, String errorMessage) {
        super(code, errorMessage);
    }
}