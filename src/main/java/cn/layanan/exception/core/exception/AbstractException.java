package cn.layanan.exception.core.exception;

import cn.layanan.exception.core.enums.ExceptionEnumHandle;

/**
 * 抽象服务异常基类（定义了基本属性及方法）
 *
 * @Author liyanan
 * @Date 2019/7/31 15:00
 */
abstract class AbstractException extends RuntimeException implements ExceptionEnumHandle {
    protected Integer code;
    protected String errorMessage;

    public AbstractException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public AbstractException(ExceptionEnumHandle exceptionEnumHandle) {
        super(exceptionEnumHandle.getMessage());
        this.code = exceptionEnumHandle.getCode();
        this.errorMessage = exceptionEnumHandle.getMessage();
    }

    public AbstractException(ExceptionEnumHandle exceptionEnumHandle, String extraMessage) {
        super(extraMessage);
        this.code = exceptionEnumHandle.getCode();
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