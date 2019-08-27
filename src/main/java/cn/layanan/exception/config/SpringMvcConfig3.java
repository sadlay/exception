package cn.layanan.exception.config;

import cn.layanan.exception.core.mvc.converter.RequestDataTypeMethodProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:24 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class SpringMvcConfig3 implements WebMvcConfigurer {

    @Autowired
    private HttpMessageConverter requestDataMessageConvert;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(requestDataMessageConvert);
        resolvers.add(new RequestDataTypeMethodProcessor(converters));
    }


}
