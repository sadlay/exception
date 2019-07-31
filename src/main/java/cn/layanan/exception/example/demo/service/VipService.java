package cn.layanan.exception.example.demo.service;

import cn.layanan.exception.example.demo.param.VipParam;

/**
 * @Description
 * @Author layanan
 * @Date 2019/7/31 16:52
 */
public interface VipService {

    VipParam verify(String encryptData);

    String doVipService(VipParam vipParam);


}
