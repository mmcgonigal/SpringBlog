package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/post")

    public  String index (Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    @RequestMapping (path="/posts/{id}", method=RequestMethod.GET)
    @ResponseBody String  indivPostView(@PathVariable int id){
        return "Current post number : " + id + " .";
    }


    @GetMapping( "/posts/create")
    public  String submit(Model model){

        model.addAttribute("post",new Post());

        return "posts/create";
        //when it is submited i need to
    }


    @PostMapping("/posts/create")
    public String updatePost(@ModelAttribute Post post){
  postDao.save(post);


        return "redirect:/post";
    }






}
