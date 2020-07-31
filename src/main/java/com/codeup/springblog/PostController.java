package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable int id){
        return "view an individual post" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "posts index page";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "create a new post";
    }

}
