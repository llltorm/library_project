package net.project.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Контроллер обрабатывает запросы на вход в систему.
 */
@Controller
public class LoginController {
    /**
     * Отображает html страницу логина.
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    /**
     * Перенаправляет успешный запрос логина на домашнюю страницу.
     */
    @PostMapping("/login")
    public String loginUser() {
        return "redirect:/home";
    }

}
