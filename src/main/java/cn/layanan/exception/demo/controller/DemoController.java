package cn.layanan.exception.demo.controller;

import cn.layanan.exception.core.result.Result;
import cn.layanan.exception.core.validate.ParamValidator;
import cn.layanan.exception.demo.param.VipParam;
import cn.layanan.exception.demo.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器demo
 *
 * @Author liyanan
 * @Date 2019/7/31 15:40
 */
@RestController
public class DemoController {

    @Autowired
    private VipService vipService;

    /**
     * TODO 建议
     * 并不建议将参数和签名混在一起当一个字符串
     * 如果是这样不如用json来传递然后接口用实体来接入，这样参数不会和其他东西耦合
     * <p>
     * TODO 正常来说步骤应为下面几步
     * 1：校验参数和签名，如果错误则向外抛出异常
     * validate(encryptData);
     * 2. 处理业务并返回结果
     * someService.doService();
     * <p>
     * TODO 但是demo1的参数需要解密后转map才能拿到，所以校验和业务互相耦合了，可以来校验后并获取自定义的参数实体VipParam，然后进行业务处理
     *
     * @auther liyanan
     * @Date 2019/7/31 15:45
     */
    @PostMapping("/demo1")
    public Result demo1(@RequestParam("encryptData") String encryptData) {

        // 解密校验并返回参数实体
        VipParam vipParam = vipService.verify(encryptData);

        //调用服务
        String result = vipService.doVipService(vipParam);

        //返回Result结果
        return Result.success(result);
    }


    /**
     * 实体接参数
     * 添加校验注解@ParamValidator可以对 VipParam进行自动校验(需要实现Validator接口)，
     * 如果失败则抛出异常到全局捕获处理返回
     *
     * @auther liyanan
     * @Date 2019/7/31 16:34
     */
    @PostMapping("/demo2")
    @ParamValidator
    public Result demo2(@RequestBody VipParam vipParam) {
        return Result.success(vipService.doVipService(vipParam));
    }
}
