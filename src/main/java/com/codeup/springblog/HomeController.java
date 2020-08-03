package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
//    @ResponseBody // remove this when using Thymeleaf template
    public String home(){
        return "home"; // templates/home.html name, case-sensitive!
    }

    @PostMapping("/")
    // pulls the attribute from the submitted form, sends it back to the view
    public String returnCohort(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", cohort);
        return "home";
    }

}
