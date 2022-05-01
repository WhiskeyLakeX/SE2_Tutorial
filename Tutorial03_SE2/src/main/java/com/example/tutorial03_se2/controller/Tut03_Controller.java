package com.example.tutorial03_se2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tut03_Controller {
    @RequestMapping(value = "/demo")
    public String homepage(Model model) {
        String text = "Hello from backenddf";
        model.addAttribute("hello", text);
        return "demo";
    }
}
