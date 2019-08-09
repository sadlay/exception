package cn.layanan.exception.core.config;

import cn.layanan.exception.core.bind.JwtTokenArgumentResolver;
import cn.layanan.exception.core.bind.PropertyNamingStrategyArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
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

    @Autowired
    private HttpMessageConverter fastJsonHttpMessageConverters;

    @Autowired
    private HttpMessageConverter requestDataMessageConvert;


    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(jwtTokenArgumentResolver);
        argumentResolvers.add(new PropertyNamingStrategyArgumentResolver(true));
/*        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(requestDataMessageConvert);
        argumentResolvers.add(new RequestDataTypeMethodProcessor(converters));*/
    }

/*
    */
/**
     * 配置请求处理器适配器
     *//*

    //@Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter original = super.requestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(requestDataMessageConvert);
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList();
        argumentResolvers.add(new RequestDataTypeMethodProcessor(converters));
        original.setCustomArgumentResolvers(argumentResolvers);
 */
/*       List<HttpMessageConverter<?>> fastjson = new ArrayList();
        fastjson.add(fastJsonHttpMessageConverters);
        original.setMessageConverters(fastjson);*//*

        return original;
    }
*/

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverters);
    }
}
