package com.company.project.authserivceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String hello(){
        String user = passwordEncoder.encode("user");
        return "Hello "+user;
    }

    @GetMapping("/meet")
    public String meet(){
        return "I meet you";
    }

    @GetMapping("/welcome")
    public String welcome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Welcome " + authentication.getName();
    }

    @GetMapping("/project")
    @PreAuthorize("hasRole('ROLE_PROJECT_ADMIN')")  //具有此角色
    public String project(){
        return "This is my project";
    }


}