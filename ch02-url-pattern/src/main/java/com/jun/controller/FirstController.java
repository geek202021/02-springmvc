package com.jun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
 * 1.创建控制器（处理器）对象
 *  控制器：叫做后端控制器（back controller），自定义的类处理请求的。
 * 2.RequestMapping作用：把指定的请求，交给指定的方法处理，等同于url-pattern
 * 3.返回值ModelAndView：表示本次请求的处理结果（数据和视图） Model表示数据
 * @author HuangJun7
 * @date 2021-11-11 16:46
 */
@Controller
public class FirstController {
//    @RequestMapping(value = "/some.do")
    @RequestMapping(value = "/some")
    public ModelAndView doSome(String name,Integer age) {
        System.out.println("执行了MyController的doSome方法,name=" + name + ",age=" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        //返回结果
        return mv;
    }
}
