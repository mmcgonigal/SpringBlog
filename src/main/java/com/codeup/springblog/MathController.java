package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class MathController {
    @RequestMapping (path="/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int num1,int num2){
        return num1+num2 ;
    }
    @RequestMapping
            (path="/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int num1,int num2){
        return num2-num1;
    }
    @RequestMapping(path = "/multiple/{num1}/from/{num2}", method= RequestMethod.GET)
    @ResponseBody public int multiple(@PathVariable int num1, int num2){
        return num1*num2;
    }
    @RequestMapping(path = "/divide/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody public int devide(@PathVariable int num1, int num2){
        return num1/num2 ;
    }


}
