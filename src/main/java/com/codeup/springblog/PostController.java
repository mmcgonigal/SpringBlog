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
    @ResponseBody String  indivPostView(@PathVariable int id){
        return "Current post number : " + id + " .";
    }


    @GetMapping( "/posts/create")
    @ResponseBody String createPost(){
        return "inputForm Form for creating a post - pardon our dust ! ";
    }


    @PostMapping("/posts/create")
   @ResponseBody
    public String submit(){
        return "creat a new post";
    }



}
