package com.springboot.server;

import com.springboot.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AUTHOR:miko
 * EMAIL:273715955@qq.com
 * TIME:2023/4/18 10:59
 * PACKAGE:com.lesson.server
 * PROJECT:AutoTest2023
 **/
@RestController
@Api(value = "/",description = "所有的POST请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true) String password){
        if(userName.equals("mouse")&&password.equals("123456")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登陆成功！";
        }
        return "用户名或者密码错误";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u){
        User user;
        Cookie[] cookies=request.getCookies();
        for(Cookie c: cookies){
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("mouse")
                    && u.getPassword().equals("123456"))
            {
                user=new User();
                user.setAge("2");
                user.setName("ross");
                user.setColor("red");
                user.setPrice("23");
                user.setUserName("lily");
                user.setPassword("******");
                return user.toString();
            }
        }
        return "参数不合法";
    }

}
