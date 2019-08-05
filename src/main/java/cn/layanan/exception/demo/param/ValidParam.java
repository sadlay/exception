package cn.layanan.exception.demo.param;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Valid参数实体
 *
 * @Author liyanan
 * @Date 2019/7/31 15:50
 */
public class ValidParam {

    /**
     * 空检查
     */

    @NotNull //验证对象是否不为null, 无法查检长度为0的字符串
    private String var1;

    @NotBlank //检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格
    private String var2;

    @NotEmpty  //检查约束元素是否为NULL或者是EMPTY.
    private String var3;

    /**
     * Bolean检查
     */

    @AssertTrue  //验证 Boolean 对象是否为 true
    private Boolean var4;

    @AssertFalse  //验证 Boolean 对象是否为 false
    private Boolean var5;


    /**
     * 长度检查
     */
    @Size(max = 5, min = 1)  //验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
    private String var6;

    @Length(max = 5, min = 1)  //验证字符串的长度是否在给定的范围之内，包含两端
    private String var7;

    /**
     * 日期检查
     */

    @Past   //验证 Date 和 Calendar 对象是否在当前时间之前
    private Date var8;

    @Future    //验证 Date 和 Calendar 对象是否在当前时间之后
    private Date var9;

    /**
     * 正则检查
     */
    @Pattern(regexp = "") //验证 String 对象是否符合正则表达式的规则
    private String var10;

    /**
     * 数值检查（建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为"",Integer为null）
     */

    @Min(100) //验证 Number 和 String 对象是否大等于指定的值
    private Integer var11;

    @Max(200) //验证 Number 和 String 对象是否小等于指定的值
    private Integer var12;

    @DecimalMax("100") //被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
    private BigDecimal var13;

    @DecimalMin("1") //被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
    private BigDecimal var14;

    @Digits(integer = 1, fraction = 2) //验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。
    private String var15;

    @Range(min = 10000, max = 50000) //限制必须在合适的范围内
    private BigDecimal var16;


    @Valid //递归的对关联对象进行校验, 如果关联对象是个集合或者数组,那么对其中的元素进行递归校验,如果是一个map,则对其中的值部分进行校验.(是否进行递归验证)
    private List<ValidParam> var18;

    @CreditCardNumber //信用卡验证，检查带注释的字符序列是否通过了Luhn校验和测试
    private String var19;

    @Email //验证是否是邮件地址，如果为null,不进行验证，算通过验证。
    private String var20;

    @URL(host = "127.0.0.1", port = 80) //URL
    private String var21;

}
