package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameIntroController {
    @GetMapping("/roll-dice")
    @ResponseBody
    public String sayHi(){
        return "index";
    }
    @RequestMapping(path="/roll-dice/{n}", method = RequestMethod.GET)
    public String diceNum(@PathVariable int n){
 return "you guessed number " + n ;


    }
}
