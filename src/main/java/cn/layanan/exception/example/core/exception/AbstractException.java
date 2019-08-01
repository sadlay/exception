package cn.layanan.exception.example.core.exception;

import cn.layanan.exception.example.core.enums.EnumHandle;

/**
 * 抽象服务异常基类（定义了基本属性及方法）
 *
 * @Author liyanan
 * @Date 2019/7/31 15:00
 */
abstract class AbstractException extends RuntimeException implements EnumHandle {
    protected Integer code;
    protected String errorMessage;

    public AbstractException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public AbstractException(EnumHandle enumHandle) {
        super(enumHandle.getMessage());
        this.code = enumHandle.getCode();
        this.errorMessage = enumHandle.getMessage();
    }

    public AbstractException(EnumHandle enumHandle, String extraMessage) {
        super(extraMessage);
        this.code = enumHandle.getCode();
        this.errorMessage = extraMessage;
    }


    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}