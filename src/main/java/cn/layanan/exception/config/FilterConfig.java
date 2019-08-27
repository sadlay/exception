package cn.layanan.exception.config;

import cn.layanan.exception.core.mvc.filter.BodyReaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * filter配置注册器
 *
 * @auther lay
 * @Date 2019/8/9 11:01
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        Filter bodyReaderFilter = new BodyReaderFilter();
        registrationBean.setFilter(bodyReaderFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(-1);
        return registrationBean;
    }
}
