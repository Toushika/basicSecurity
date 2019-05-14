package com.enigma.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile/index";
    }

    @GetMapping("/profile/userProfile")
    public String userProfile(){
        return "profile/userProfile";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("/admin/userAdmin")
    public String userAdmin(){
        return "admin/userAdmin";
    }

    @GetMapping("/manager")
    public String manager(){
        return "manager/index";
    }



}

