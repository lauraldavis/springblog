package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String viewProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "profile";
    }

//    @GetMapping("/profile/edit")
//    public String editProfile(Model model){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        return "profile";
//    }

    @PostMapping("/profile")
    public String viewLoginInfo(@RequestParam(name="username") String username, @RequestParam(name="password") String password, Model model){
        ArrayList<String> posts = new ArrayList<String>();
        boolean isLoggedIn = true;
        posts.add("Ad 1");
        posts.add("Ad 2");
        posts.add("Ad 3");

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("posts", posts);
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "profile";
    }

}
