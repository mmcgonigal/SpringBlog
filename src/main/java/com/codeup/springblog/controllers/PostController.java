package com.codeup.springblog.controllers;


import com.codeup.springblog.model.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.Services.EmailService;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }




    @GetMapping("/post")

    public  String index (Model model) {
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("users", userDao.findAll());


        return "posts/index";
// ArrayList<post> allPost = (ArrayList<Post>.postDao.finaAll();
        //model.addAttribute("allPost",allPost)

    }

    @GetMapping (path="/post/{id}")
    public String  indivPostView(@PathVariable long id,Model model){
        Post post = postDao.getById(id);
        model.addAttribute("singlePost",post);
        return "posts/show";
    }


    @GetMapping( "/post/create")
    public  String posting(Model model){

        model.addAttribute("post",new Post());

        return "posts/create";
        //when it is submited i need to
    }


    @PostMapping("/post/create")
    public String addPost(@ModelAttribute Post post){

        User user= userDao.getById(4L);  // find one user  to hard set for posting for now because it comes as null if i dont assign any user,
        post.setUser(user); // <-- this will be setting     user for post.


        postDao.save(post);

        emailService.prepareAndSend(post,post.getTitle(),post.getDescription());


        return "redirect:/post";
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

    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        Post post = postDao.getById(id);

        model.addAttribute("post",post);
        return "posts/edit";

    }

    @PostMapping("post/{id}/edit")
    public String editAndSubmit(@PathVariable long id,@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/post";
    }











}
