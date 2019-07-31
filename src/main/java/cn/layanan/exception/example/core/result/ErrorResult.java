package cn.layanan.exception.example.core.result;

/**
 * 错误结果封装
 *
 * @Author liyanan
 * @Date 2019/7/31 14:22
 */
public class ErrorResult extends Result {
    public static final Integer ERROR_CODE = -1;
    public static final String ERROR_MESSAGE = "网络异常";

    public ErrorResult() {
        super(ERROR_CODE, ERROR_MESSAGE, (Object) null);
    }

    public ErrorResult(String message) {
        super(ERROR_CODE, message, (Object) null);
    }

    public ErrorResult(Integer code, String message) {
        super(code, message, (Object) null);
    }

    public ErrorResult(Object object) {
        super(ERROR_CODE, ERROR_MESSAGE, object);
    }

    public ErrorResult(String message, Object object) {
        super(ERROR_CODE, message, object);
    }
}
