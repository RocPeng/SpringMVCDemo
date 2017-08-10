package com.ambition.controller;

import com.alibaba.fastjson.JSON;
import com.ambition.domain.User;
import com.ambition.domain.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roc_peng on 2017/8/9.
 * Email 18817353729@163.com
 * Url https://github.com/RocPeng/
 * Description 注解的方式配置controller
 */
//不以"/"开头的mapping配置 会自动加上
@Controller
@RequestMapping("hello2")
public class Hello2Controller {

    //普通风格
    @RequestMapping("/show")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        return mv;
    }


    /**Ant风格的映射(通配符)
     * ?：通配一个字符
     * *：通配0个或者多个字符
     * **：通配0个或者多个路径
     */
    @RequestMapping("/aa*/ant1")
    public ModelAndView shorAnt1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","Ant风格的映射方式111 : *");
        return mv;
    }

    @RequestMapping("/**/ant2")
    public ModelAndView shorAnt2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","Ant风格的映射方式222 : **");
        return mv;
    }

    @RequestMapping("/?/ant3")
    public ModelAndView shorAnt3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","Ant风格的映射方式222 : ?");
        return mv;
    }

    /**
     * 占位符的形式
     */
    @RequestMapping("/show1/{id}")
    public ModelAndView show1(@PathVariable("id")String id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        System.out.println(id);
        mv.addObject("msg","占位符风格的映射方式111 : id:"+id);
        return mv;
    }
    @RequestMapping("/{id}/{name}/{price}/show2")
    public ModelAndView show2(@PathVariable("id") String id, @PathVariable("name") String name,
                              @PathVariable("price") String price){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","接收3个参数id="+id+"  name="+name+"  price="+price);
        return mv;
    }

    /**
     * 限定请求方法的映射
     */
    @RequestMapping(value = "/show3",method = RequestMethod.POST)
    public ModelAndView method1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","限定请求方法:只能使用post");
        return mv;
    }

    @RequestMapping(value = "/show4",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView method2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","限定请求方法:可以使用Get或者Post");
        return mv;
    }

    /**限定请求参数的映射
    @RequestMapping(value=””,params=””)
    params=”userId”：请求参数中必须带有userId
    params=”!userId”：请求参数中不能包含userId
    params=”userId=1”：请求参数中userId必须为1
    params=”userId!=1”：请求参数中userId必须不为1，参数中可以不包含userId
    params={“userId”, ”name”}：请求参数中必须有userId，name参数
     */
    @RequestMapping(value = "/param1",params = "id")
    public ModelAndView params1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","参数id: id");
        return mv;
    }

    @RequestMapping(value = "/param2",params = "!id")
    public ModelAndView params2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","参数id: 不能包含id");
        return mv;
    }

    @RequestMapping(value = "/param3",params = "id=1")
    public ModelAndView params3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","参数id: 必须为1");
        return mv;
    }

    @RequestMapping(value = "/param4",params = "id!=1")
    public ModelAndView params4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","参数id: 必须不等于1");
        return mv;
    }

    /**
     * 接收数据及数据绑定
     接收servlet的内置对象
     接收占位符请求路径中的参数
     接收普通的请求参数
     获取cookie参数
     基本数据类型的绑定
     Pojo对象的绑定
     集合的绑定
     */
    /**
     * 接收servlet的内置对象
     */
    @RequestMapping("/built1")
    public ModelAndView built1(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView("hello2");
        StringBuilder sb = new StringBuilder();
        sb.append("request内置对象:"+request+"</br>");
        sb.append("response内置对象:"+response+"</br>");
        sb.append("session内置对象:"+session+"</br>");
        mv.addObject("msg",sb.toString());
        return mv;
    }

    @RequestMapping("/built2")
    public ModelAndView built1(Model model, ModelMap modelMap){
        ModelAndView mv = new ModelAndView("hello2");
        //最终只显示最后一个
        model.addAttribute("msg","springmvc内置对象model:");
        modelMap.addAttribute("msg","springmvc内置对象modelMap:");
        modelMap.addAttribute("msg","springmvc内置对象modelMap第二个!!!:");
        return mv;

    }

    /**
     * 获取cookie
     */
    @RequestMapping("cookie1")
    public ModelAndView cookie1(HttpServletRequest request,Model model){
        ModelAndView mv = new ModelAndView("hello2");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            model.addAttribute("msg","cookie获取:"+cookie.getValue());
        }
        return mv;
    }

    @RequestMapping("cookie2")
    public String cookie2(Model model,@CookieValue("JSESSIONID") String cookie){
        model.addAttribute("msg","cookie注解获取:"+cookie);
        return "hello2";
    }

    /**
     * 接收请求路径中的占位符
     @PathVariable(value=”id”)获取占位符中的参数
     注意：(value=”id”)不能省
     */

    @RequestMapping("holder1/{id}")
    public String holder1(Model model, @PathVariable("id") String pid){
        model.addAttribute("msg","id占位符获取:"+pid);
        return "hello2";
    }

    /**
     * 接收普通的请求参数
     http://localhost:8080/sss.do?id=xxx
     @RequestParam(value=””, required=true/false, defaultValue=””)
     Value：参数名
     required：是否必须，默认为true，标示请求参数中必须包含该参数，如果不包含则抛出异常
     defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false，如果请求中不包含该参数则使用默认值。
     */

    @RequestMapping("params1")
    public String params1(Model model, @RequestParam("id") String pid,@RequestParam("username") String name){
        model.addAttribute("msg","参数获取:id="+pid+"  username="+name);
        return "hello2";
    }

    @RequestMapping("params2")
    public String params2(Model model, @RequestParam(value = "id",required = false) String pid,
                          @RequestParam(value = "username",required = false) String name){
        model.addAttribute("msg","参数获取:id="+pid+"  username="+name);
        return "hello2";
    }

    @RequestMapping("params3")
    public String params3(Model model, @RequestParam(value = "id",required = false) String pid,
                          @RequestParam(value = "username",required = false,defaultValue = "dick") String name){
        model.addAttribute("msg","参数获取:id="+pid+"  username="+name);
        return "hello2";
    }

    @RequestMapping("bind1")
    public String bind1(Model model,@RequestParam("name") String name,@RequestParam("age") Integer age,
                        @RequestParam("isMarry") boolean isMarry,@RequestParam("income") Double income,
                        @RequestParam("interests") String[] interests){
        StringBuilder sb = new StringBuilder();
        User user = new User(name, age, isMarry, income, interests);
        model.addAttribute("msg", JSON.toJSONString(user));
        return "hello2";
    }

    @RequestMapping("bind2")
    public String bind2(Model model,User user){
        model.addAttribute("msg",JSON.toJSONString(user));
        System.out.println("服务端接收user对象:"+user);
        return "hello2";
    }

    /**
     * 集合的绑定
     如果方法需要接受的list集合，不能够直接在方法中书写List
     List的绑定，需要将List对象包装到一个类中才能绑定
     要求：表单中的name的值
     要求表单name的值， 和封装的对象中的结合的属性名一致。
     User对象：
     */
    @RequestMapping("list1")
    public String list1(Model model, UserModel userModel){
        model.addAttribute("msg",userModel);
        return "hello2";
    }

    /**
     * 当一个处理请求的方法标记为@ResponseBody时，表示该方法需要输出其他视图（json、xml，默认输出json），
     * springmvc通过默认的转化器转化输出
     @RequestBody
     */
    @RequestMapping(value = "json1")
    @ResponseBody
    public List<User> json1(){
        List<User> list = new ArrayList<>();
        String[] interests = {"足球"};
        for(int i=0;i<5;i++){
            User user = new User("roc" + i, 22, false, 6666.6, interests);
            list.add(user);
        }
        return list;
    }

    @RequestMapping(value = "json2")
    @ResponseBody
    public Map json2(){
        Map<String,String> map = new HashMap<>();
        map.put("username","roc");
        return map;
    }

    /**
     * @RequestBody:接收json数据，并把json数据转化成java实体
     */
    @RequestMapping("/json3")
    @ResponseBody
    public User json3(@RequestBody User user){
        System.out.println("接收json对象:"+user);
        return user;
    }
    @RequestMapping("/json4")
    @ResponseBody
    public String json4(@RequestBody String json){
        System.out.println("接收json字符串:"+json);
        return json;
    }

    /**
     * 文件上传
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(file!=null){
            file.transferTo(new File("/Users/roc_peng/Downloads/"+file.getOriginalFilename()));
        }
        return "redirect:/success.html";
    }

    /**
     * 转发：forward:/hello/show.do
     重定向：redirect:/hello/show.do
     默认是转发，所以转发只需要这么写：/hello/show.do
     RedirectAttributes是Spring mvc 3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的
     他有两种带参的方式：
     第一种：
     attr.addAttribute("param", value);
     这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，
     但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险
     第二种：
     attr.addFlashAttribute("param", value);
     这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。
     所以你刷新一下后这个值就会丢掉
     */
    @RequestMapping("redirect")
    public String redirect(RedirectAttributes attributes){
        attributes.addAttribute("id","251");
        attributes.addFlashAttribute("username","FlashAttribute中的值,页面刷新会消失~");
        return "redirect:/hello2/forward.do";
    }

    @RequestMapping("forward")
    public String forward(Model model,@RequestParam("id") String id/*,@RequestParam("username") String username*/){

        model.addAttribute("msg","id="+id);
        return "hello2";
    }

    @RequestMapping("flash1")
    public String flashDemo1(RedirectAttributes attributes){
        attributes.addAttribute("msg","调用addAttribute");
        return "forward:/flashdemo.jsp";
    }
}
