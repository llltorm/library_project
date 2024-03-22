package net.project.library.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHomePage() {
        return "home";
    }
}
