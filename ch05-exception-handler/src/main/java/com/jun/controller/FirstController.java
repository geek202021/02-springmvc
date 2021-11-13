package com.jun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jun.bean.Student;
import com.jun.exception.AgeException;
import com.jun.exception.MyUserException;
import com.jun.exception.NameException;
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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        System.out.println("执行了FirstController的doSome方法");
        //抛出异常
        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确！");
        }
        if (age == null || age.intValue() > 80) {
            throw new AgeException("年龄太大！");
        }
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        //返回结果
        return mv;
    }
}
