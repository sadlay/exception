package cn.layanan.exception.config;

import cn.layanan.exception.core.mvc.converter.RequestDataMessageConvert;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用FastJson替换SpringBoot自带的Json解析工具
 *
 * @Author: lay
 * @Date: Created in 19:00 2019/8/6
 * @Modified By:IntelliJ IDEA
 */
@Configuration
public class FastJsonMessageConfig {

    @Bean
    public HttpMessageConverter requestDataMessageConvert() {
        return new RequestDataMessageConvert();
    }

    //引入Fastjson解析json，不使用默认的jackson
    //必须在pom.xml引入fastjson的jar包，并且版必须大于1.2.10

    @Bean
    @ConditionalOnClass(FastJsonHttpMessageConverter.class)
    public HttpMessageConverter fastJsonHttpMessageConverters() {
        //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //  输出key是包含双引号
//        SerializerFeature.QuoteFieldNames,
                //  是否输出为null的字段,若为null 则显示该字段
//        SerializerFeature.WriteMapNullValue,
                //  数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //   List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //  字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //  Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //  Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //  循环引用
                SerializerFeature.DisableCircularReferenceDetect,
        };

        // 中文乱码解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
        fastConverter.setSupportedMediaTypes(mediaTypes);

        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));

        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        //4、将convert添加到converters中
        HttpMessageConverter<?> converter = fastConverter;

        //return new HttpMessageConverters(converter);
        return converter;
    }


}
