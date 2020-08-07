package com.codeup.springblog.services;

import org.springframework.stereotype.Service;

@Service("GreetingService") // the name is optional, use it if you want to access it without dependency injection
public class GreetingService {

    public String goodMorning(String name) {
        return "Good Morning " + name + "!";
    }

    public String goodAfternoon(String name) {
        return "Good Afternoon " + name + "!";
    }

    public String goodEvening(String name) {
        return "Good Evening " + name + "!";
    }

}
