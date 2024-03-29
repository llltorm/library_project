package net.project.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер обрабатывает запросы домашней страницы.
 */
@Controller
public class HomeController {
    /**
     * Метод перенапрвляет запрос на home траницу.
     */
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    /**
     * Метод перенапрвляет запрос на home траницу.
     */
    @GetMapping("/")
    public String redirectHomePage() {
        return "home";
    }
}
