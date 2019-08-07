package cn.layanan.exception.demo.controller;

import cn.layanan.exception.core.bind.JwtToken;
import cn.layanan.exception.core.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:17 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@RestController
public class JwtTokenController {

    @GetMapping("/jwt")
    public Result jwtMethod(@JwtToken String jwt) {
        return Result.success(jwt);
    }
}
