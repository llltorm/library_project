package net.project.library.controller;

import net.project.library.model.Reader;
import net.project.library.model.TakenBooks;
import net.project.library.service.ReaderService;
import net.project.library.service.TakenBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TakenBookController {
    private final TakenBooksService takenBooksService;

    @Autowired
    public TakenBookController(TakenBooksService takenBooksService) {
        this.takenBooksService = takenBooksService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/takenBooks")
    public String findAll(Model model) {
        List<TakenBooks> takenBooks = takenBooksService.findALL();
        model.addAttribute("takenBooks", takenBooks);
        return "takenBooks-list";
    }

}
