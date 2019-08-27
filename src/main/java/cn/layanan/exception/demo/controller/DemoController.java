package cn.layanan.exception.demo.controller;

import cn.layanan.exception.core.enums.SecurityErrorEnum;
import cn.layanan.exception.core.exception.Exceptions;
import cn.layanan.exception.core.exception.ServiceException;
import cn.layanan.exception.core.mvc.RequestData;
import cn.layanan.exception.core.result.Result;
import cn.layanan.exception.core.validate.NotEqual;
import cn.layanan.exception.demo.param.VipParam;
import cn.layanan.exception.demo.service.VipService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 控制器demo
 *
 * @Author liyanan
 * @Date 2019/7/31 15:40
 */
@RestController
@Validated
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
    //@ParamValidator
    public Result demo2(/*@RequestBody @Validated VipParam vipParam,*/ HttpServletRequest request) throws IOException {
        //Map<String, String[]> parameterMap = request.getParameterMap();
//        System.out.println(JSON.toJSONString(parameterMap));
     /*    ServletInputStream inputStream = request.getInputStream();
       InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);*/
        BufferedReader bufferedReader = request.getReader();
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            System.out.println(line);
            sb.append(line);
        }
        //JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        Object parse = JSON.parse(sb.toString());

        return Result.success(parse);
    }

    @GetMapping("/demo3")
    public Result demo3(@NotEmpty @Email @Length(min = 10, max = 20) @NotEqual({"123456@email.com", "654321@email.com"}) String email) {
        if (!email.equals("123456@qq.com")) {
            throw Exceptions.service(SecurityErrorEnum.EMAIL_ERROR, "邮箱不等于123456@qq.com");
        }
        return Result.success(email);
    }

    @PostMapping("/vip")
    public Result demo3(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer();
        char[] charBuffer = new char[128];
        int bytesRead = -1;
        while ((bytesRead = reader.read(charBuffer)) > 0) {
            sb.append(charBuffer, 0, bytesRead);
        }
        VipParam vipParam = JSONObject.parseObject(sb.toString(), VipParam.class);
        return Result.success(vipParam);
    }


    @GetMapping("/demo4")
    public Result demo4(HttpServletRequest request, HttpServletResponse response) {
        VipParam vipParam = new VipParam();
        vipParam.setChannle_code("code");
        return Result.success(vipParam);
    }

    @PostMapping("/demo5")
    public Result demo5(RequestData requestData, HttpServletRequest request) throws IOException {
        VipParam vipParam = new VipParam();
        vipParam.setChannle_code("code");

        ServletInputStream inputStream = request.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        BufferedReader bufferedReader = request.getReader();
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            System.out.println(line);
            sb.append(line);
        }
/*        char[] charBuffer = new char[128];
        int bytesRead = -1;
        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
            sb.append(charBuffer, 0, bytesRead);
        }*/
        //JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        Object parse = JSON.parse(sb.toString());

        return Result.success(requestData);
    }
}
