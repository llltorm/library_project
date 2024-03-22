package net.project.library.controller;

import net.project.library.model.Book;
import net.project.library.model.Reader;
import net.project.library.model.Messages;
import net.project.library.service.BookService;
import net.project.library.service.MessageService;
import net.project.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReaderController {
    private final ReaderService readerService;

    private final BookService bookService;

    private final MessageService messageService;

    @Autowired
    public ReaderController(ReaderService readerService, BookService bookService, MessageService messageService) {
        this.readerService = readerService;
        this.bookService = bookService;
        this.messageService = messageService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/readers")
    public String showFormWithAllReaders(Model model) {
        List<Reader> readers = readerService.findALL();
        model.addAttribute("readers", readers);
        return "reader-list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reader-create")
    public String createReaderForm(Reader reader) {
        return "reader-create";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/reader-create")
    public String createReader(Reader reader) {
        readerService.saveReader(reader);
        reader.setRole("USER");
        return "redirect:/readers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reader-delete/{id}")
    public String deleteReader(@PathVariable("id") int id) {
        readerService.deleteById(id);
        return "redirect:/readers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("reader-update/{id}")
    public String updateReaderForm(@PathVariable("id") int id, Model model) {
        Reader reader = readerService.findById(id);
        model.addAttribute(reader);
        return "/reader-update";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("reader-update")
    public String updateReader(Reader reader) {
        String password = reader.getPassword();
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("add-take-book/{id}")
    public String showAddTakenBookForm(@PathVariable("id") int id, Model model) {
        Reader reader = readerService.findById(id);
        List<Reader> readers = readerService.findALL();
        List<Book> listBook = bookService.findALL();
        for (Reader readerFromList : readers) {
            if (listBook.contains(readerFromList.getBookId())) {
                listBook.remove(readerFromList.getBookId());
            }
        }
        model.addAttribute("reader", reader);
        model.addAttribute("listBook", listBook);
        return "/reader-add-take-book";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("add-take-book")
    public String addTakenBook(Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("reader-delete-take-book/{id}")
    public String deleteTakenBook(@PathVariable("id") int id, Model model) {
        Reader reader = readerService.findById(id);
        Book book = bookService.findById(reader.getBookId().getId());
        String nameBook = book.getName();
        reader.setBookId(null);
        readerService.saveReader(reader);
        Messages message = new Messages("Книга " + nameBook + " вернулась в библиотеку");
        System.out.println(message);
        messageService.saveMessage(message);
        return "redirect:/readers";
    }
}
