package cn.layanan.exception.core.validate;

/**
 * 参数验证
 *
 * @Author liyanna
 * @Date 2019/7/31 15:53
 */
public interface Validator {

    default String validate() {
        return null;
    }
}
