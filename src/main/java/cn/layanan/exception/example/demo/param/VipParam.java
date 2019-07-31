package cn.layanan.exception.example.demo.param;

import cn.layanan.exception.example.core.validate.Validator;

/**
 * Vip参数实体
 *
 * @Author liyanan
 * @Date 2019/7/31 15:50
 */
public class VipParam implements Validator {
    private String phone;

    private String channle_code;

    private String pay_time;

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
        return null;
    }
}
