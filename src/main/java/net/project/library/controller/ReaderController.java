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

/**
 * Контроллер, обрабатывающий запросы, которые касаются читателей библиотеки.
 */
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

    /**
     * Метод для полужения из БД всех читателей и их отображение на странице.
     *
     * @param model - в модель добавляются все пользователи, найденные в БД
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/readers")
    public String showFormWithAllReaders(Model model) {
        List<Reader> readers = readerService.findAll();
        model.addAttribute("readers", readers);
        return "reader-list";
    }

    /**
     * Метод отображения формы создания нового читателя.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reader-create")
    public String createReaderForm(Reader reader) {
        return "reader-create";
    }

    /**
     * Метод сохраняет данные, введённые пользователем на HTML странице в БД.
     *
     * @param reader - экземпляр читателя, сохраняемый в БД
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/reader-create")
    public String createReader(Reader reader) {
        reader.setRole("USER");
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    /**
     * Метод удаления читателя по id.
     *
     * @param id - идентификатор удаляемого читателя
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reader-delete/{id}")
    public String deleteReader(@PathVariable("id") int id) {
        readerService.deleteById(id);
        return "redirect:/readers";
    }

    /**
     * Метод отображения формы обновления читателя.
     *
     * @param id - идентификатор обновляемого читателя
     * @param model - содержит читателя, который будет обновлен
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("reader-update/{id}")
    public String updateReaderForm(@PathVariable("id") int id, Model model) {
        Reader reader = readerService.findById(id);
        model.addAttribute(reader);
        return "/reader-update";
    }

    /**
     * Метод обновляет данные, введённые пользователем на HTML странице в БД.
     *
     * @param reader - экземпляр читателя, обновляемого в БД
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("reader-update")
    public String updateReader(Reader reader, Model model) {
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    /**
     * Метод отображает список всех книг, которые можно добавить читателю.
     *
     * @param id - идентификатор читателя, которому добавляется книга
     * @param model - содержит информацию о выбранном читателе и всех возможных книгах
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("add-take-book/{id}")
    public String showAddTakenBookForm(@PathVariable("id") int id, Model model) {
        Reader reader = readerService.findById(id);
        List<Reader> readers = readerService.findAll();
        List<Book> listBook = bookService.findAll();
        for (Reader readerFromList : readers) {
            if (listBook.contains(readerFromList.getBookId())) {
                listBook.remove(readerFromList.getBookId());
            }
        }
        model.addAttribute("reader", reader);
        model.addAttribute("listBook", listBook);
        return "/reader-add-take-book";
    }

    /**
     * Метод добавляет выбранную книгу читателю.
     *
     * @param reader - экземпляр выбранного читателя с добавленной книгой
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("add-take-book")
    public String addTakenBook(Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    /**
     * Метод удаления книги у выбранного читателя.
     *
     * @param id - идентификатор выбранного читателя
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("reader-delete-take-book/{id}")
    public String deleteTakenBook(@PathVariable("id") int id, Model model) {
        try {
            Reader reader = readerService.findById(id);
            Book book = bookService.findById(reader.getBookId().getId());
            String nameBook = book.getName();
            reader.setBookId(null);
            readerService.saveReader(reader);
            Messages message = new Messages("Книга " + nameBook + " вернулась в библиотеку");
            System.out.println(message);
            messageService.saveMessage(message);
        } catch (Exception e) {
            System.out.println("Нет книги для удаления");
        }
        return "redirect:/readers";
    }
}
