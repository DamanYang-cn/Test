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

    @PutMapping("/login")
    public Boolean Login(@RequestBody User user, HttpServletResponse response){
        User result = userRepository.findByName(user.getName());
        if(result.getPassword().equals(user.getPassword())){
            System.out.println("success");
            Cookie cookie = new Cookie("name",result.getName());
            response.addCookie(cookie);
            return true;
        }
        else{
            return false;
        }
    }
    @GetMapping("/show")
    public String show(@CookieValue(value = "name") String name){
        return name;
    }
    @GetMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("name")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }
}
