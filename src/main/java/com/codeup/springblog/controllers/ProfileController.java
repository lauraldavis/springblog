package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProfileController {

    @GetMapping("/profile/{username}")
    public String viewProfile(@PathVariable String username, Model model){
        model.addAttribute("user", username);
        return "profile";
    }

    @GetMapping("/profile")
    public String viewProfile(){
        return "profile";
    }

    @PostMapping("/profile")
    public String viewLoginInfo(@RequestParam(name="username") String username, @RequestParam(name="password") String password, Model model){
        ArrayList<String> ads = new ArrayList<String>();
        boolean isLoggedIn = true;
        ads.add("Ad 1");
        ads.add("Ad 2");
        ads.add("Ad 3");

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("ads", ads);
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "profile";
    }

}
