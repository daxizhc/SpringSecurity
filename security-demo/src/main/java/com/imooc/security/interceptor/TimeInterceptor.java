package com.imooc.security.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        System.out.println(((HandlerMethod)o).getBean().getClass().getName());
        System.out.println(((HandlerMethod)o).getMethod().getName());
        httpServletRequest.setAttribute("start", new Date().getTime());
        return true;
    }

    @Override
    // 异常抛出不调用
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start = (Long)httpServletRequest.getAttribute("start");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - start));
    }

    @Override
    // 都会被调用
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        Long start = (Long)httpServletRequest.getAttribute("start");
        System.out.println("time interceptor 耗时：" + (new Date().getTime() - start));
        System.out.println("ex:" + e);
    }
}
