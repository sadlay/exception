package cn.layanan.exception.config;

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
