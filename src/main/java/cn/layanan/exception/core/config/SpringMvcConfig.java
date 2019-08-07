package cn.layanan.exception.core.config;

import cn.layanan.exception.core.bind.JwtTokenArgumentResolver;
import cn.layanan.exception.core.bind.PropertyNamingStrategyArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:24 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtTokenArgumentResolver jwtTokenArgumentResolver;

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(jwtTokenArgumentResolver);
        argumentResolvers.add(new PropertyNamingStrategyArgumentResolver(true));
    }
}
