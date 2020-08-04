package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DiceController {


    @GetMapping("/roll-dice")
    public String ViewRollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{dice}")
    public String viewRollDice(@PathVariable int dice, Model model){
        int roll = (int) (Math.random() * 6) + 1;
        String result;
        if (roll == dice) {
            result = "You win!";
        } else {
            result = "Better luck next time!";
        }
        model.addAttribute("roll", roll);
        model.addAttribute("guess", dice);
        model.addAttribute("result", result);
        return "roll-dice-result";
    }

}
