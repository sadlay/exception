package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.EnumHandle;

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

    public static AbstractException request(EnumHandle enumHandle) {
        return new RequestException(enumHandle);
    }

    public static AbstractException request(EnumHandle enumHandle, String msg) {
        return new RequestException(enumHandle, msg);
    }

    public static AbstractException security(Integer code, String msg) {
        return new SecurityException(code, msg);
    }

    public static AbstractException security(EnumHandle enumHandle) {
        return new SecurityException(enumHandle);
    }

    public static AbstractException security(EnumHandle enumHandle, String msg) {
        return new SecurityException(enumHandle, msg);
    }

    public static AbstractException service(Integer code, String msg) {
        return new ServiceException(code, msg);
    }

    public static AbstractException service(EnumHandle enumHandle) {
        return new ServiceException(enumHandle);
    }

    public static AbstractException service(EnumHandle enumHandle, String msg) {
        return new ServiceException(enumHandle, msg);
    }
}
