package com.fzshuai.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 软件二班傅同学
 * @description 拦截异常处理
 * @date 2021-02-06 19:26
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    // 获取日志对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 错误异常处理
    @ExceptionHandler(Exception.class)      //标识异常的注解
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {

        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(), e);
        // 当标识了状态码的时候就不拦截
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        // 将记录的异常信息返回到error页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
