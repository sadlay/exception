package cn.layanan.exception.core.enums;

/**
 * 错误异常枚举
 *
 * @auther liyanan
 * @Date 2019/7/31 14:16
 */
public enum RequestErrorEnum implements ErrorCodeEnum {

    PARAM_ERROR(-1001, "参数错误或不完整！"),
    RSA_DECRYPT_ERROR(-1002, "解密失败！"),
    SIGN_ERROR(-1003, "签名错误！"),
    SIGN_EXPIRED(-1004, "签名过期！"),
    EMAIL_ERROR(-1005,"邮箱异常");

    private Integer code;
    private String message;

    RequestErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
