package cn.layanan.exception.demo.param;

import cn.layanan.exception.core.util.EmptyUtil;
import cn.layanan.exception.core.validate.Insert;
import cn.layanan.exception.core.validate.Update;
import cn.layanan.exception.core.validate.Validator;

import javax.validation.constraints.NotEmpty;

/**
 * Vip参数实体
 *
 * @Author liyanan
 * @Date 2019/7/31 15:50
 */
public class VipParam implements Validator {

    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @NotEmpty(message = "编码不能为空")
    private String channle_code;

    @NotEmpty(message = "支付时间不能为空")
    private String pay_time;

    public VipParam() {
    }

    public VipParam(String phone, String channle_code, String pay_time) {
        this.phone = phone;
        this.channle_code = channle_code;
        this.pay_time = pay_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannle_code() {
        return channle_code;
    }

    public void setChannle_code(String channle_code) {
        this.channle_code = channle_code;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    @Override
    public String validate() {
        if (EmptyUtil.isEmpty(phone)) {
            return "phone为空";
        }
        if (EmptyUtil.isEmpty(channle_code)) {
            return "channle_code为空";
        }
        if (EmptyUtil.isEmpty(pay_time)) {
            return "pay_time为空";
        }
        return null;
    }
}
