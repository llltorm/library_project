package net.project.library.controller;

import net.project.library.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final ReaderService readerService;

    public RegistrationController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/login")
    public String ShowLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "redirect:/home";
    }

}
