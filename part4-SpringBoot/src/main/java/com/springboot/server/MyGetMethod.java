package com.springboot.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@Api(value = "/",description = "所有的GET请求")
public class MyGetMethod {
    //开发一个返回cookie的get请求
    @RequestMapping(value="/getCookie",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("zhangfen","123456");
        response.addCookie(cookie);
        return "恭喜获得cookies成功";
    }

    //开发一个需要携带cookie才能访问的get请求
    @RequestMapping(value = "/get/with/cookie",method = RequestMethod.GET)
    public String getWithCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookie信息";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookie信息才能访问的get请求！";
            }
        }
        return "你必须携带cookie信息";
    }

    //开发一个需要携带参数才能访问的get请求
    //实现方式一 url: key=value&key=value
    //访问方法：http://localhost:8888/get/with/param?start=1&end=2
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("西红柿炒蛋",18);
        myList.put("青椒肉丝",20);
        myList.put("干煸豆角",16);
        myList.put("小炒肉",25);
        return myList;
    }

    //开发一个需要携带参数才能访问的get请求
    //实现方式二：路径
    //访问方法：http://localhost:8888/get/with/param/1/2
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("西红柿炒蛋盖饭",18);
        myList.put("青椒肉丝盖饭",20);
        myList.put("干煸豆角盖饭",16);
        myList.put("小炒肉盖饭",25);
        return myList;

    }
}
