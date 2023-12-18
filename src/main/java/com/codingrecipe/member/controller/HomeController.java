package com.codingrecipe.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {

        if (session.getAttribute("loginEmail")!=null){
            return "loginhome";
        }
            return "index";
    }
}
