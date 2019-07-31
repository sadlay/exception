package cn.layanan.exception.example.demo.service.impl;

import cn.layanan.exception.example.core.enums.ErrorCodeEnum;
import cn.layanan.exception.example.core.exception.RequestException;
import cn.layanan.exception.example.demo.param.VipParam;
import cn.layanan.exception.example.demo.service.VipService;
import cn.layanan.exception.example.demo.util.RSACoder;
import cn.layanan.exception.example.demo.util.RSAConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * VIp服务实现类
 *
 * @Author liyanan
 * @Date 2019/7/31 16:52
 */
@Service
public class VipServiceImpl implements VipService {
    private static final Logger log = LoggerFactory.getLogger(VipServiceImpl.class);

    @Override
    public VipParam verify(String encryptData) {

        //解密数据（因为有异常代码块，所以单独写出一个方法方便阅读）
        String decryptData = decrypt(encryptData);

        //转换为map对象
        Map<String, Object> data = parseMap(decryptData);

        //校验签名是否正确或超时
        verifySign(data);

        //转换为VipParam参数
        return parseVipParam(data);
    }


    private String decrypt(String encryptData) {
        String decryptData;
        try {
            byte[] bytes = RSACoder.decryptByPrivateKey(encryptData.getBytes(), RSAConstants.PRIVATE_KEY);
            decryptData = new String(bytes);
        } catch (Exception e) {
            log.error("RSA解密错误", e);
            throw new RequestException(ErrorCodeEnum.RSA_DECRYPT_ERROR);
        }
        return decryptData;
    }

    private Map<String, Object> parseMap(String decryptData) {
        Map<String, Object> data = new HashMap<>();
        try {
            data = JSONObject.parseObject(decryptData);
        } catch (Exception e) {
            log.error("格式转为错误", e);
            throw new RequestException(ErrorCodeEnum.RSA_DECRYPT_ERROR);
        }
        return data;
    }

    private void verifySign(Map<String, Object> data) {
        String sign = (String) data.get("sign");
        data.remove("sign");
        boolean success;
        try {
            success = RSACoder.verify(JSON.toJSONString(data).getBytes(), RSAConstants.SIGN_PUBLIC_KEY, sign);
        } catch (Exception e) {
            success = false;
        }
        if (!success) {
            throw new RequestException(ErrorCodeEnum.SIGN_ERROR);
        }
    }

    private VipParam parseVipParam(Map<String, Object> data) {
        String phone = (String) data.get("phone");
        String channle_code = (String) data.get("channle_code");
        String pay_time = (String) data.get("pay_time");
        return new VipParam(phone, channle_code, pay_time);
    }

    @Override
    public String doVipService(VipParam vipParam) {
        return null;
    }
}
