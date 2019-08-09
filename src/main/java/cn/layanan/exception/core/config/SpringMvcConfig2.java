package cn.layanan.exception.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:24 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
/*@Configuration
public class SpringMvcConfig2  {

    @Autowired
    private HttpMessageConverter requestDataMessageConvert;


    *//**
     * 配置请求处理器适配器
     *//*
    //@PostConstruct
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(@Autowired RequestMappingHandlerAdapter original) {
        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(requestDataMessageConvert);
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList();
        argumentResolvers.add(new RequestDataTypeMethodProcessor(converters));
        original.setCustomArgumentResolvers(argumentResolvers);
 *//*       List<HttpMessageConverter<?>> fastjson = new ArrayList();
        fastjson.add(fastJsonHttpMessageConverters);
        original.setMessageConverters(fastjson);*//*
        return original;
    }

}*/
