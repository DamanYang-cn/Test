package com.daman.controller;

import com.daman.entity.User;
import com.daman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/show/{n}")
    public String doshow(HttpServletRequest request, HttpServletResponse response, @PathVariable("n") String n){
        System.out.println("do show v");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(n)){
                return cookie.getValue();
            }
        }
        return "Not Found";
    }

    @GetMapping("/add/{c}")
    public void add(HttpServletResponse response, @PathVariable("c") String c){
        Cookie cookie = new Cookie("test",c);
        response.addCookie(cookie);
    }

    @GetMapping("/checkL")
    public Boolean showLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("cName")){
                return true;
            }
        }
        return false;
    }

    @PostMapping("/login")
    public Boolean Login(@RequestBody User user, HttpServletResponse response){
        User result = userRepository.findByNameAndPassword(user.getName(),user.getPassword());
        if(result!=null){
            System.out.println(user.getName()+"_success");
            Cookie cname = new Cookie("cName",result.getName());
            Cookie cright = new Cookie("cRight",result.getRight());
            response.addCookie(cname);
            response.addCookie(cright);
            return true;
        }
        else{
            return false;
        }
    }
    @GetMapping("/show")
    public String show(HttpServletRequest request){
        String name = "null";
        String right = "null";
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("cName")){
                name = cookie.getValue();
            }
            if(cookie.getName().equals("cRight")){
                right = cookie.getValue();
            }
        }
        return name+"_"+right;
    }
    @GetMapping("/out")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("cName") || cookie.getName().equals("cRight")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
    @GetMapping("/login")
    public void Login(HttpServletResponse response){
        Cookie cname = new Cookie("cName","test");
        Cookie cright = new Cookie("cRight","1");
        response.addCookie(cname);
        response.addCookie(cright);
    }
}
