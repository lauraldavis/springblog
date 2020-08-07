package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao; // dependency injection - Spring Boot uses IOC inversion of control
    private final UserRepository usersDao; // " is required to create any new objects

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    // returns json - one post
    @GetMapping("/posts/json/{id}")
    @ResponseBody
    public String getPost(@PathVariable long id){
        return postsDao.getOne(id).toString();
    }

    // returns json - list of posts
    @GetMapping("/posts/json")
    @ResponseBody
    public List<Post> getPosts() {
        return postsDao.findAllByOrderByIdDesc();
    }

    // return a Thymeleaf view
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
        Post post = postsDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
        postsDao.save(post);
        return "redirect:/posts/view";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePostById(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "/posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name="id") long id) {
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
        User user = usersDao.getOne(1L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts/view";
    }

}
