package cn.layanan.exception.core.config;

import cn.layanan.exception.core.exception.RequestException;
import cn.layanan.exception.core.exception.SecurityException;
import cn.layanan.exception.core.exception.ServiceException;
import cn.layanan.exception.core.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常捕获处理器
 *
 * @Author liyanan
 * @Date 2019/7/31 14:39
 */
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截安全权限异常（通常为鉴权和认证错误时候抛出）
     *
     * @auther liyanna
     * @Date 2019/7/31 15:34
     */
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result requestException(SecurityException e) {
        log.error("权限异常:", e);
        return Result.error(e);
    }

    /**
     * 拦截业务异常（通常为请求参数验证错误等时候抛出）
     *
     * @auther liyanna
     * @Date 2019/7/31 15:34
     */
    @ExceptionHandler(RequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result requestException(RequestException e) {
        log.error("请求异常:", e);
        return Result.error(e);
    }

    /**
     * 拦截业务异常（通常为业务处理时无法进行时手动抛出）
     *
     * @auther liyanna
     * @Date 2019/7/31 15:34
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result serviceException(ServiceException e) {
        log.error("业务异常:", e);
        return Result.error(e);
    }

    /**
     * 拦截未知的运行时异常
     *
     * @auther liyanna
     * @Date 2019/7/31 15:34
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result unknownException(RuntimeException e) {
        log.error("运行时异常:", e);
        return Result.error("SERVER ERROR");
    }
}
