package com.zlabwork.genesis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String listUser(Model model) {
        model.addAttribute("date", new Date());
        return "welcome";
    }

}