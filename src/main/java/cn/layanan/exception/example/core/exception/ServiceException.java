package cn.layanan.exception.example.core.exception;

import cn.layanan.exception.example.core.enums.EnumHandle;

/**
 * 服务异常（通常为业务处理时无法进行时手动抛出）
 *
 * @Author liyanan
 * @Date 2019/7/31 15:00
 */
public class ServiceException extends AbstractException {

    public ServiceException(EnumHandle enumHandle) {
        super(enumHandle);
    }

    public ServiceException(EnumHandle enumHandle, String extraMessage) {
        super(enumHandle, extraMessage);
    }

    public ServiceException(Integer code, String errorMessage) {
        super(code, errorMessage);
    }
}