package com.zlabwork.genesis.controller;

import com.zlabwork.genesis.entity.UserEntity;
import com.zlabwork.genesis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/web")
    public String listUser(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "title", required = false, defaultValue = "World") String title,
            Model model
    ) {
        Iterable<UserEntity> users;
        // 1.
        if (search.length() > 0) {
            users = userRepository.searchUserByName(search);
        } else {
            users = userRepository.findAll();
        }
        model.addAttribute("users", users);
        model.addAttribute("title", title);
        return "user/list";
    }

    @PostMapping("/web")
    public String createUser(
            @RequestParam String name,
            @RequestParam(name = "email", required = false, defaultValue = "") String email
    ) {

        Date date = new Date();
        UserEntity data = new UserEntity();
        data.setName(name);
        data.setEmail(email);
        data.setDate(date);
        userRepository.save(data);

        // redirect
        return "redirect:/web";
    }

    @RequestMapping("/web/{id}")
    public String deleteUser(@PathVariable String id) {

        try {
            Integer idx = Integer.parseInt(id);
            userRepository.deleteById(idx);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/web";
    }


}