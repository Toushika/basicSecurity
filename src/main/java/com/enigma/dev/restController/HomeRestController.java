package com.enigma.dev.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("api/test1")
    public String  test1(){
        return "Welcome to java world ";
    }

    @GetMapping("api/test2")
    public String  test2(){
        return "Welcome to python world ";
    }
}
