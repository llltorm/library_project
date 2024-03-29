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

/**
 * Контроллер, обрабатывающий запросы, которые касаются книг в библиотеке.
 */
@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Метод для полужения из БД всех книг и их отображения на странице.
     *
     * @param model - в модель добавляются все книги, найденные в БД
     * @return - возвращается HTML страница со всеми книгами
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/books")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    /**
     * Метод отображения формы создания новой книги.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    /**
     * Метод сохраняет данные, введённые пользователем на HTML странице в БД.
     *
     * @param book - экземпляр книги, сохраняемой в БД
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/book-create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    /**
     * Метод удаления книги по id.
     *
     * @param id - идентификатор удаляемой книги
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    /**
     * Метод отображения формы обновления книги.
     *
     * @param id - идентификатор обновляемой книги
     * @param model - содержит книгу, которая будет обновлена
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("book-update/{id}")
    public String updateBookForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute(book);
        return "/book-update";
    }

    /**
     * Метод обновляет данные, введённые пользователем на HTML странице в БД.
     *
     * @param book - экземпляр книги, обновляемой в БД
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("book-update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
