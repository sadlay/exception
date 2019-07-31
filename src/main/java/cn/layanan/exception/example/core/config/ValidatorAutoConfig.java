package cn.layanan.exception.example.core.config;

import cn.layanan.exception.example.core.validate.ParamValidatorAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 参数校验自动配置（加载bean）
 *
 * @Author liyanan
 * @Date 2019/7/31 16:31
 */
@Configuration
public class ValidatorAutoConfig {

    @Bean
    public ParamValidatorAop paramValidateAop() {
        return new ParamValidatorAop();
    }

}
