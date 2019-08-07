package cn.layanan.exception.demo.controller;

import cn.layanan.exception.core.bind.PropertyNaming;
import cn.layanan.exception.core.result.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:49 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@RestController
@Validated
public class PropertyNamingController {

    @GetMapping("naming")
    @Validated
    public Result naming(@PropertyNaming Test test) {
        return Result.success(test.getUserName());
    }
}

