package net.project.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер обрабатывает ошибки в приложении.
 */
@Controller
public class ErrorController {

    /**
     * Выводит страницу 403 ошибку, в случае её возникновения.
     */
    @GetMapping("/403")
    public String error403() {
        return "error-403";
    }
}
