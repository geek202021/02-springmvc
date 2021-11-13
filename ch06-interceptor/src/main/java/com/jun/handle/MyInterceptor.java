package com.jun.handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author HuangJun7
 * @date 2021-11-13 13:46
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     *  preHandle: 预先处理请求的方法。
     *  参数：Object handler:被拦截的控制器对象（InterceptorController）
     *  返回值： boolean
     *   true: 请求是正确的，可以被controller处理的。
     *     =====InterceptorController拦截器的preHandle====
     *     执行了InterceptorController的doSome方法
     *     =====InterceptorController拦截器的postHandle====
     *     =====InterceptorController拦截器的afterCompletion====
     *   false: 请求不能被处理， 控制器方法不会执行。 请求到此截止。
     *     =====InterceptorController拦截器的preHandle====
     * 特点：
     *  1. 预处理方法他的执行时间： 在控制器方法之前先执行的。
     *  2. 可以对请求做处理， 可以做登录的检查， 权限的判断， 统计数据等等。
     *  3. 可以决定请求是否执行。（开发中主要使用的方法）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====MyInterceptor拦截器的preHandle====");
        //获取登录的账号信息
        String username ="";
        Object attr = request.getSession().getAttribute("username");
        if (attr != null) {
            username=(String)attr;
        }
        //判断账号
        if ("zhangsan".equals(username)) {
            return true;
        } else {
            //如果return false，可以加一个提示
        request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        System.out.println("=====MyInterceptor拦截器的postHandle====");
        //当preHandle返回为true此方法执行，可以对请求做二次处理
        if (mv != null) {
            //修改数据
            mv.addObject("myDate", new Date());
            //修改视图
            mv.setViewName("show");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=====MyInterceptor拦截器的afterCompletion====");
    }
}
