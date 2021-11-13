package com.jun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-13 10:46
 */
@Controller
public class FirstController {
    /**
     * 控制器方法返回的是ModelAndView实现转发forward
     *  语法：mv.setViewName("forward:视图完整路径")
     *      forward特点：不和视图解析器一同工作，就当项目中没有视图解析器。
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward() {
        System.out.println("执行了MyController的doForward方法");
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了doForward.do的请求");
        mv.addObject("fun", "执行了doForward方法");
        //显示使用forward指定转发操作
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        //返回结果
        return mv;
    }

    /**
     * 当控制器方法返回ModelAndView实现重定向
     * 语法：mv.setViewName("redirect:视图完整路径");
     * redirect特点：不和视图解析器一同工作，就当项目中没哟视图解析器
     * 框架提供的重定向的功能：
     * 1.框架可以实现两次请求之间的数据传递，把第一个请求中的Model里面简单类型的数据，转为字符串，
     *   附加到目标页面的后面，做get参数传递。可以在目标页面中获取参数值使用。
     * http://localhost:8080/ch04_forward_redirect/second.jsp?myName=Sisyphus&myAge=34
     * 2.在目标页面中，可以使用${param.参数名}，获取参数的值
     * 3.重定向不能访问受保护的文件夹下的页面：/WEB-INF
     */
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        System.out.println("doRedirect, name="+name+",age="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("redirect:/second.jsp");
        //重定向不能访问/WEB-INF
        //mv.setViewName("redirect:/WEB-INF/view/second.jsp");
        return mv;
    }
}
