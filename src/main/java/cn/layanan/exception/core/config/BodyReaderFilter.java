package cn.layanan.exception.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 数据读取过滤器(在Filter中将ServletRequest替换为ServletRequestWrapper)
 *
 * @Author: lay
 * @Date: Created in 10:51 2019/8/9
 * @Modified By:IntelliJ IDEA
 */
public class BodyReaderFilter extends HttpFilter {
    private static Logger log= LoggerFactory.getLogger(BodyReaderFilter.class);
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("包装bodyFilter");
        BodyReaderHttpServletRequestWrapper bodyReaderHttpServletRequestWrapper = new BodyReaderHttpServletRequestWrapper(request);
        chain.doFilter(bodyReaderHttpServletRequestWrapper, response);
    }
}
