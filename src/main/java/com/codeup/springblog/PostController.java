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
// ArrayList<post> allPost = (ArrayList<Post>.postDao.finaAll();
        //model.addAttribute("allPost",allPost)

    }


    @GetMapping (path="/posts/{id}")
    public String  indivPostView(@PathVariable int id,Model model){


        Post post = postDao.getById((long) id);
        model.addAttribute("singlePst",post);
        return "posts/show";

    }


    @GetMapping( "/post/create")
    public  String posting(Model model){

        model.addAttribute("post",new Post());

        return "posts/create";
        //when it is submited i need to
    }


//    // this is refactored with Kenneth lecture-review
//    @GetMapping("post/create")
//    public String addPost(@RequestParam(name="title") String title,@RequestParam(name="description") String description) {
//        System.out.println("title = " + title);
//        System.out.println("description = " + description);
//        postDao.save(new Post(title, description));
//        return "redirect:/posts";
//
//    }

        @PostMapping("/post/create")
    public String addPost(@ModelAttribute Post post){
  postDao.save(post);


        return "redirect:/post";
    }







}
