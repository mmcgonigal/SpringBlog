package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/post")

    public  String index (Model model) {
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("users", userDao.findAll());
        return "posts/index";


    }


    @GetMapping (path="/posts/{id}")
    public String  indivPostView(@PathVariable int id,Model model){


        return "Current post number : " + id + " .";
    }


    @GetMapping( "/post/create")
    public  String posting(Model model){

        model.addAttribute("post",new Post());

        return "posts/create";
        //when it is submited i need to
    }


    @PostMapping("/post/create")
    public String addPost(@ModelAttribute Post post){
  postDao.save(post);


        return "redirect:/post";
    }






}
