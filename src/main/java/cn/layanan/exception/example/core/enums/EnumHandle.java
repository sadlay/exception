package cn.layanan.exception.example.core.enums;

/**
 * 枚举类处理接口（枚举实现此接口）
 *
 * @Author liyanan
 * @Date 2019/7/31 14:04
 */
public interface EnumHandle {

    /**
     * 获取状态码
     *
     * @auther liyanan
     * @Date 2019/7/31 15:37
     */
    Integer getCode();

    /**
     * 获取描述信息
     *
     * @auther liyanan
     * @Date 2019/7/31 15:37
     */
    String getMessage();
}
