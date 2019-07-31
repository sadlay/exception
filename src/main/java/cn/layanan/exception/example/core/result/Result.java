package cn.layanan.exception.example.core.result;

import cn.layanan.exception.example.core.enums.EnumHandle;

/**
 * 返回结果封装
 *
 * @Author liyanan
 * @Date 2019/7/31 14:22
 */
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /* 快速静态返回方法 */

    public static Result success() {
        return new SuccessResult();
    }

    public static Result success(Object object) {
        return new SuccessResult(object);
    }

    public static Result success(String message, Object object) {
        return new SuccessResult(message, object);
    }

    public static Result error(String message) {
        return new ErrorResult(message);
    }

    public static Result error(Object object) {
        return new ErrorResult(object);
    }

    public static Result error(String message, Object object) {
        return new ErrorResult(message, object);
    }

    public static Result error(EnumHandle enumHandle) {
        return new ErrorResult(enumHandle.getCode(), enumHandle.getMessage());
    }

}
