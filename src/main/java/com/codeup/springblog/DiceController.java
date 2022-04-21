package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {
    @GetMapping("/roll-dice/")
    public String sayHi(){
        return"rollDiceView";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessNumber(Model model, @PathVariable int n){

            model.addAttribute("guessNumber",n);

            int randomNumber = (int)Math.floor(1+Math.random()*6);
            model.addAttribute("actualNumber",randomNumber);



            return"rollDiceView";
    }


//    @GetMapping("/roll-dice") // 접속할 URL  , GetMapping 으로 연결
//    @ResponseBody
//    public String sayHi(){
//
//    }
//    @RequestMapping(path="/roll-dice/{n}", method = RequestMethod.GET)
//    public String diceNum(@PathVariable int n, Model model){
// return "you guessed number " + n ;


    }

