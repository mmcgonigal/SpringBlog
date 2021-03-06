package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // defines class is the controller
public class HelloController {
    @GetMapping("/hello") // get method ,---> this will be the landing page when it get method is invoked
    @ResponseBody
    public String hello(){

        return "Hello there from the Sirius cohort";
    }
    @RequestMapping(path="/hello/{name}/and/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String helloNameAge(@PathVariable String name, @PathVariable int age){
        return "Hey user! Thanks for letting me know  your name is " + name +" . "+
                "You also told me you were " + age + " years old. ";
    }

}
