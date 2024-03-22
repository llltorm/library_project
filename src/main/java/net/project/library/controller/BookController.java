package net.project.library.controller;

import net.project.library.model.Book;
import net.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/books")
    public String findAll(Model model) {
        List<Book> books = bookService.findALL();
        model.addAttribute("books", books);
        return "book-list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/book-create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("book-update/{id}")
    public String updateBookForm(@PathVariable("id") int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute(book);
        return "/book-update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("book-update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("book-returned")
    public String updateBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute(book);
        return "/book-update";
    }

}
