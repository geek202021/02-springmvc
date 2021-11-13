package com.jun.controller;

import com.jun.bean.User;
import com.jun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HuangJun7
 * @date 2021-11-12 20:45
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 声明引用类型，调用引用类型的业务方法
     *  引用类型自动注入 @AutoWired @Resource
     */
    @Autowired
    private UserService service;
    //添加用户
    @RequestMapping("/addUser.do")
    public ModelAndView addUser(User user) {
        ModelAndView mv = new ModelAndView();
        //调用service，处理业务逻辑，把处理结果返回给用户
        int rows = service.addUser(user);
        String msg = "注册失败！";
        if (rows > 0) {
            //注册成功，给用户成功的数据和视图
            msg = "注册成功！";
        }
        mv.addObject("msg", user.getName() + "," + msg);
        mv.setViewName("result");
        return mv;
    }
}
