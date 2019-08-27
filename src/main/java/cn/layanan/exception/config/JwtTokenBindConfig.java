package cn.layanan.exception.config;

import cn.layanan.exception.core.bind.JwtTokenArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:15 2019/8/7
 * @Modified By:IntelliJ IDEA
 */

@Configuration
public class JwtTokenBindConfig {

    @Bean
    public JwtTokenArgumentResolver jwtTokenArgumentResolver() {
        return new JwtTokenArgumentResolver();
    }
}
