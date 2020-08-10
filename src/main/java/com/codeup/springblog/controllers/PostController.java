package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao; // dependency injection - Spring Boot uses IOC inversion of control
    private final UserRepository usersDao; // " is required to create any new objects
    private final EmailService emailService;

    public PostController(PostRepository postsDao,
                          UserRepository usersDao,
                          EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String redirect() {
        return "redirect:/posts/view";
    }

    // JSON - one post
    @GetMapping("/posts/json/{id}")
    @ResponseBody
    public String getPost(@PathVariable long id){
        return postsDao.getOne(id).toString();
    }

    // JSON - list of posts
    @GetMapping("/posts/json")
    @ResponseBody
    public List<Post> getPosts() {
        return postsDao.findAllByOrderByIdDesc();
    }

    // The rest are Thymeleaf pages

    @GetMapping("/posts/view")
    public String getPosts(Model model) {
        model.addAttribute("posts", postsDao.findAllByOrderByIdDesc());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getOnePost(@PathVariable long id, Model model){
        model.addAttribute("onePost", postsDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostById(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@RequestParam(name="id") long id,
                             @RequestParam(name="title") String title,
                             @RequestParam(name="body") String body, Model model) {
        // TODO: validate logged in user can edit the post
//        User user = usesDao.getDao.getOne(3L);
        Post post = postsDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
//        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts/view";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePostById(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name="id") long id) {
        // TODO: validate logged in user can delete the post
        postsDao.deleteById(id);
        return "redirect:/posts/view";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        // TODO: once we get to Spring Security, capture logged in user (hard coded for now)
        // don't delete user.id 4! killsmany@plants.com (username: trying2hard)
        User user = usersDao.getOne(4L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts/view";
    }

    @GetMapping("/email")
    @ResponseBody
    public String sendEmail() {
        // don't delete post.id 18! Waterlily, Nymphaeaceae / Nymphaea ×thiona Ward
        emailService.prepareAndSend(postsDao.getOne(18L), "Test Email!", "Testing sendEmail method from the PostController in springblog application!");
        return "Check your mailtrap inbox!";
    }

}
