package cn.layanan.exception.example.core.result;

/**
 * 成功结果封装
 *
 * @Author liyanan
 * @Date 2019/7/31 14:22
 */
public class SuccessResult extends Result {
    public static final Integer SUCCESS_CODE = 1;
    public static final String SUCCESS_MESSAGE = "操作成功";

    public SuccessResult() {
        super(SUCCESS_CODE, SUCCESS_MESSAGE, (Object) null);
    }

    public SuccessResult(Object object) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE, object);
    }

    public SuccessResult(String message, Object object) {
        super(SUCCESS_CODE, message, object);
    }
}
