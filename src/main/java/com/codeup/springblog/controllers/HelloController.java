package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name +" from a GetMapping path!";
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id){
        // Connect to db to get book for this id
        // Return view
        return "Viewing book " + id;
    }

//    @PostMapping - will do this later

    @RequestMapping(path = "/hello2/{myName}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello2(@PathVariable String myName){
        return "Hello " + myName +" from a RequestMapping path!";
    }

}
