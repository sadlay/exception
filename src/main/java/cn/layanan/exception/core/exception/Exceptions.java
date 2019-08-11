package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.ExceptionEnumHandle;

/**
 * 异常工具类
 *
 * @Author: lay
 * @Date: Created in 18:27 2019/8/1
 */

public final class Exceptions {
    public static AbstractException request(Integer code, String msg) {
        return new RequestException(code, msg);
    }

    public static AbstractException request(ExceptionEnumHandle exceptionEnumHandle) {
        return new RequestException(exceptionEnumHandle);
    }

    public static AbstractException request(ExceptionEnumHandle exceptionEnumHandle, String msg) {
        return new RequestException(exceptionEnumHandle, msg);
    }

    public static AbstractException security(Integer code, String msg) {
        return new SecurityException(code, msg);
    }

    public static AbstractException security(ExceptionEnumHandle exceptionEnumHandle) {
        return new SecurityException(exceptionEnumHandle);
    }

    public static AbstractException security(ExceptionEnumHandle exceptionEnumHandle, String msg) {
        return new SecurityException(exceptionEnumHandle, msg);
    }

    public static AbstractException service(Integer code, String msg) {
        return new ServiceException(code, msg);
    }

    public static AbstractException service(ExceptionEnumHandle exceptionEnumHandle) {
        return new ServiceException(exceptionEnumHandle);
    }

    public static AbstractException service(ExceptionEnumHandle exceptionEnumHandle, String msg) {
        return new ServiceException(exceptionEnumHandle, msg);
    }
}
