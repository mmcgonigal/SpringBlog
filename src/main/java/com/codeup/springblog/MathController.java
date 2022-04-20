package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MathController {

    // this controller shold listen for request for several routes that correspond to basic  arithmetic operation and produce  the result of the arithmetic operation and produce the result of the arithmetic

    //i add/num1/and/num2
    @GetMapping ("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1,int num2){
        return "Here is the result of  num 1 + num 2 : " + num1+num2 ;
    }


    @GetMapping
            ("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1,int num2){
        return num2-num1;
    }

    @GetMapping("/multiple/{num1}/from/{num2}")
    @ResponseBody public int multiple(@PathVariable int num1, int num2){
        return num1*num2;
    }

    @RequestMapping(path = "/divide/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody public int devide(@PathVariable int num1, int num2){
        return num1/num2 ;
    }

}
