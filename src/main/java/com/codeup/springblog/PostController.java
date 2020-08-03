package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(2, "Title-2", "Post-2"));
        posts.add(new Post(3, "Title-3", "Post-3"));
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post newPost = new Post(id, "First Post", "This is the first post");
        model.addAttribute("title", newPost.getTitle());
        model.addAttribute("body", newPost.getBody());
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(){
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert() {
        return "/posts/create";
    }

}
