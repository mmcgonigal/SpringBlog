package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody String index(){
        return "Hello. Hola, 안녕, Ni-hao";
    }

    @RequestMapping (path="/posts/{id}", method=RequestMethod.GET)
    @ResponseBody String  indivPost(@PathVariable int id){
        return "Current post number : " + id + " .";
    }

//    @RequestMapping( "/posts/create")
//    @ResponseBody String createForm(){
//        return "inputForm";
//    }
//    @PostMapping("/posts/create")
//   public String createForm(){
//        return
//    }
//

}
