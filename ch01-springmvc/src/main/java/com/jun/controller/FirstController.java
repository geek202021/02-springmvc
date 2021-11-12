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
@RequestMapping("/test")
public class FirstController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {
        System.out.println("执行了MyController的doSome方法");
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了some.do的请求");
        mv.addObject("fun", "执行了doSome方法");
        //指定视图 setViewName("视图的完整路径")
//        mv.setViewName("show.jsp");
//        mv.setViewName("/WEB-INF/view/show.jsp");
//        mv.setViewName("/WEB-INF/view/other.jsp");

        //当配置了视图解析器，使用文件名称作为视图名使用
        mv.setViewName("show");
        //返回结果
        return mv;
        /**
         * 当框架调用完doSome()方法后，得到返回值ModelAndView。
         * 框架会在后续处理逻辑值，处理mv对象里面的数据和视图
         * 对数据执行request.setAttribute("msg","处理了some.do的请求");把数据放入到request作用域
         * 对视图执行forward转发操作，等同于request.getRequestDispatcher("/show.jsp").forward(..)
         */
    }

    //    @RequestMapping(value = {"/other.do", "/second.do"},method = RequestMethod.POST)
    @RequestMapping(value = {"/other.do", "/second.do"}) //不指定method属性，请求方式没有限制
    public ModelAndView doOther(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
        System.out.println("执行了MyController的doOther方法");
        String name = req.getParameter("name");
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了second.do请求,name的值是：" + name);
        mv.setViewName("second");
        return mv;
    }

    /**
     * 逐个接收请求的参数：要求请求中的参数名和控制器方法的形参一样，按名称对象接收请求参数
     * 如果请求参数名和形参名不一样，@RequestParam解决名称不一样的问题
     * 【属性】value、required：boolean类型的，默认是true
     * doThird(@RequestParam(value = "rname") String name,
     *
     * @RequestParam(value="rage")Integer age))
     * 参数接收：
     * 1.框架使用request对象，接收参数
     * String name = request.getParameter("name")
     * String age = request.getParameter("age");
     * 2.在中央调度器的内部调用doThird方法时，按名称对象传递参数
     * doPropertyParam(name,Integer.valueOf(age))
     * 框架可以实现请求参数String到int，long，float，double等类型的转换。
     */
    @RequestMapping(value = "/third.do")
    public ModelAndView doThird(String name, Integer age) {
        System.out.println("执行了MyController的doThird方法,name和age的分别值是：" + name + ", age=" + age);
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 控制器方法返回String，表示逻辑名称，需要项目中配置视图解析器
     */
    @RequestMapping(value = "fourth.do")
    public String doFourth(HttpServletRequest req, String name, Integer age) {
        System.out.println("name=" + name + ", age=" + age);
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        //返回结果，forward转发到show.jsp
        return "show";
    }

    /**
     * 控制器方法返回的是void，响应ajax请求。使用HttpServletResponse输出数据
     * (void不常用，返回值被Object更好的替代了)
     */
    @RequestMapping(value = "/return-void-ajax.do")
    public void returnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("处理void返回类型，name= " + name + ",age=" + age);
        //调用service得到结果对象
        Student stu = new Student();
        stu.setName(name + "同学");
        stu.setAge(age);
        //把对象转为json
        ObjectMapper om = new ObjectMapper(); // jackson
        String json = om.writeValueAsString(stu);
        System.out.println("服务器端对象转为的json==" + json);
        //输出json，响应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /**
     * 控制器方法返回Student--json
     * 框架的处理模式：
     * 1.框架根据处理器方法的返回值类型，找到HttpMessageConvert接口的实现类
     * 最后找到的是MappingJackson2HttpMessageConverter.
     * 2.使用实现类MappingJackson2HttpMessageConverter.执行它的write()方法，
     * 把student对象转为了json格式的数据
     * 3.框架使用@ReponseBody注解，把2中的json输出给了浏览器。
     */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象Student，转为json：" + name + "==" + age);
        Student stu = new Student();
        stu.setName("同学" + name);
        stu.setAge(age);
        return stu;
    }

    /**
     * 控制器方法返回的是List<Student>--json array
     */
    @RequestMapping("/doListJsonArray.do")
    @ResponseBody
    public List<Student > doAjaxJsonArray(String name, Integer age) {
        System.out.println("控制器方法返回List<Student>,转为jsonArray：" + name + "==" + age);
        Student stu = new Student();
        stu.setName("张三同学");
        stu.setAge(30);
        Student stu1 = new Student();
        stu1.setName("李四同学");
        stu1.setAge(23);
        List<Student> list = new ArrayList<>();
        list.add(stu);
        list.add(stu1);
        return list;
    }

    /**
     * 控制器方法返回String-数据
     *  区分返回值String是数据还是视图
     *  1.方法上面有@ResponseBody注解就是数据
     *  2.方法上面没有@ResponseBody注解就是视图
     *
     *  浏览器响应栏显示：Hello SpringMVC?????~【因为设置的是json，先改设置为dataType:"text",出现中文乱码】
     *  Content-Type：text/plain;charset=ISO-8859-1 告诉浏览器，怎么显示服务器返回的数据
     *   【@ResponseBody不走过滤器，所以过滤器无效，所以要指定produces属性】
     *    解决中文乱码的问题：需要使用@RequestMapping的produces属性：
     *      produces属性：指定content-type的值
     *  框架处理String返回值：
     *  1.框架使用的StringHttpMessageConverter
     *  2.StringHttpMessageConverter使用的是text/plain;charset=ISO-8859-1
     */
    @RequestMapping(value = "/doStringData.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age) {
        System.out.println("控制器方法返回String，是数据：");
        return "Hello SpringMVC注解是开发~";
    }

}
