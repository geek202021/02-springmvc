package com.jun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HuangJun7
 * @date 2021-11-13 13:43
 */
@Controller
public class InterceptorController {
    @RequestMapping(value = "/second.do")
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("执行了InterceptorController的doSome方法");
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("second");
        //返回结果
        return mv;
    }
}
