package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    // returns json
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable long id){
        return postsDao.getOne(id).toString();
    }


    // returns json
    @GetMapping("/posts")
    @ResponseBody
    public List<Post> getPosts() {
        return postsDao.findAll();
    }

    // return a Thymeleaf view
    @GetMapping("/posts/view")
    public String getPostsIndex(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post myPost = postsDao.getOne(id);
        model.addAttribute("post", myPost);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String returnPost(@RequestParam(name="id") long id,
                             @RequestParam(name="title") String title,
                             @RequestParam(name="body") String body, Model model) {
        Post post = new Post();
        post.setId((int)id);
        post.setTitle(title);
        post.setBody(body);
        postsDao.save(post);
        return "redirect:/posts/view";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePostById(@PathVariable long id, Model model) {
        Post deletePost = postsDao.getOne(id);
        model.addAttribute("post", deletePost);
        return "/posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name="id") long id) {
        Post postId = postsDao.getOne(id);
        postsDao.delete(postId);
        return "redirect:/posts/view";
    }

//    @GetMapping("/posts/create")
//    public String showCreateForm(Model model){
//        model.addAttribute("post", new Post());
//        return "/posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String create(@ModelAttribute Post post) {
//        postDao.save(post);
//        return "redirect:/posts/index";
//    }

}
