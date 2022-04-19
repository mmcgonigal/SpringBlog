package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name){
        return "Welcome to this brower " + name;
    }
}
