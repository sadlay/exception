package cn.layanan.exception.core.bind;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 11:07 2019/8/7
 * @Modified By:IntelliJ IDEA
 */
public class JwtTokenArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        boolean result = methodParameter.hasParameterAnnotation(JwtToken.class);
        return result;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String authorization = request.getHeader("Authorization");
/*        String result = null;
        if (authorization != null) {
            JwtToken jwtTokenAnnotation = methodParameter.getMethodAnnotation(JwtToken.class);
            if (jwtTokenAnnotation != null) {
                result = JwtUtil.get(authorization, jwtTokenAnnotation.value());
            }
        }*/
        return authorization;
    }


}
