package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codeup.springblog.services.GreetingService;
import com.codeup.springblog.services.SillyService;

@Controller
public class ServiceTestController {

    private final GreetingService greetingService;
    private final SillyService sillyService;
    private final EmailService emailService;
    private final PostRepository postsDao;

    public ServiceTestController(GreetingService greetingService,
                                 SillyService sillyService,
                                 EmailService emailService,
                                 PostRepository postsDao){
        this.greetingService = greetingService;
        this.sillyService =  sillyService;
        this.emailService = emailService;
        this.postsDao = postsDao;
    }

    @GetMapping("/morning/{name}")
    @ResponseBody
    public String morningGreeting(@PathVariable String name) {
        return greetingService.goodMorning(name);
    }

    @GetMapping("/afternoon/{name}")
    @ResponseBody
    public String afternoonGreeting(@PathVariable String name) {
        return greetingService.goodAfternoon(name);
    }

    @GetMapping("/evening/{name}")
    @ResponseBody
    public String eveningGreeting(@PathVariable String name) {
        return greetingService.goodEvening(name);
    }

    @GetMapping("/silly")
    @ResponseBody
    public int totalLengthPosts() {
        return sillyService.totalPostCharacters();
    }

    @GetMapping("/emailtest")
    @ResponseBody
    public String testEmail() {
        emailService.prepareAndSend(postsDao.getOne(1L), "First Email!", "Testing!");
        return "Check your mailtrap inbox!";
    }
}
