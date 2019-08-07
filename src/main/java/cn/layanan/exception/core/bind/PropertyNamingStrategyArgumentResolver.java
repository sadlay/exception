package cn.layanan.exception.core.bind;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:38 2019/8/7
 * @Modified By:IntelliJ IDEA
 */

public class PropertyNamingStrategyArgumentResolver extends ModelAttributeMethodProcessor {
    public PropertyNamingStrategyArgumentResolver(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean b = parameter.hasParameterAnnotation(PropertyNaming.class);
        return b;
    }

/*    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String name = ModelFactory.getNameForParameter(parameter);
        Object attribute = modelAndViewContainer.containsAttribute(name) ? modelAndViewContainer.getModel().get(name) : createAttribute(parameter);
        WebDataBinder binder=binderFactory.createBinder(webRequest,attribute,name);
        if(binder.getTarget()!=null){
            if(!modelAndViewContainer.isBindingDisabled(name)){
                bindRequestParameters(binder, webRequest);
            }
            validateIfApplicable(binder, parameter);
            if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(binder, parameter)) {
                throw new BindException(binder.getBindingResult());
            }
        }
        // Add resolved attribute and BindingResult at the end of the model
        Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
        modelAndViewContainer.removeAttributes(bindingResultModel);
        modelAndViewContainer.addAllAttributes(bindingResultModel);

        return binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType(), parameter);
    }*/


    protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter methodParam) {
        int i = methodParam.getParameterIndex();
        Class<?>[] paramTypes = methodParam.getMethod().getParameterTypes();
        boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
        return !hasBindingResult;
    }

/*    protected void validateIfApplicable(WebDataBinder binder, MethodParameter methodParam) {
        Annotation[] annotations = methodParam.getParameterAnnotations();
        for (Annotation ann : annotations) {
            Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
            if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = (validatedAnn != null ? validatedAnn.value() : AnnotationUtils.getValue(ann));
                Object[] validationHints = (hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
                binder.validate(validationHints);
                break;
            }
        }
    }*/


    protected Object createAttribute(MethodParameter methodParam) throws Exception {

        return BeanUtils.instantiateClass(methodParam.getParameterType());
    }
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        Map<String, String[]> result = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(!parameterMap.isEmpty()) {
            Set<String> keys = parameterMap.keySet();
            for (String key : keys) {
                result.put(key, parameterMap.get(key));
                String translate = SnakeCaseStrategy.translate(key);
                if(translate.equals(key)){
                    continue;
                }
                result.put(translate, parameterMap.get(key));
            }
        }
        MutablePropertyValues mpvs = new MutablePropertyValues(result);
        binder.bind(mpvs);
    }

    public static class SnakeCaseStrategy {

        public static String translate(String input)
        {
            // garbage in, garbage out
            if (input == null) return input;
            int length = input.length();
            StringBuilder result = new StringBuilder(length * 2);
            boolean wasPrevTranslated = false;
            for (int i = 0; i < length; i++)
            {
                // skip first starting underscore
                char c = input.charAt(i);
                if (i > 0 && c == '_')
                {
                    wasPrevTranslated = true;
                } else if (Character.isLowerCase(c) && wasPrevTranslated) {
                    result.append(Character.toUpperCase(c));
                    wasPrevTranslated = false;
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }
}
